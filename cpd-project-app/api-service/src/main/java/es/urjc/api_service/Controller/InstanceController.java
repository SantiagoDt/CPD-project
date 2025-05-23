package es.urjc.api_service.Controller;


import es.urjc.api_service.Dto.DataDTO;
import es.urjc.api_service.Dto.DiskRequestDTO;
import es.urjc.api_service.Model.Disk;
import es.urjc.api_service.Model.Instance;
import es.urjc.api_service.Service.DiskStorageService;
import es.urjc.api_service.Service.InstanceStorageService;
import es.urjc.api_service.Service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/instances")
public class InstanceController {

    @Autowired
    private InstanceStorageService instanceService;
    @Autowired
    private DiskStorageService diskService;
    @Autowired
    private MessageProducerService messageService;

    @GetMapping("/")
    public Page<Instance> getInstances(Pageable pageable) {
        return instanceService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instance> getInstance(@PathVariable Long id) {
        Optional<Instance> instanceOpt = instanceService.findById(id);
        return ResponseEntity.of(instanceOpt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instance> deleteInstance(@PathVariable Long id) {
        Optional<Instance> instanceOpt = instanceService.findById(id);
        instanceOpt.ifPresent(instance -> {
            Disk disk = instance.getDisk();
            disk.setStatus(Disk.DiskStatus.UNASSIGNED);
            diskService.save(disk);
            instanceService.deleteById(id);
        });
        return ResponseEntity.of(instanceOpt);
    }

    @PostMapping("/")
    public ResponseEntity<Instance> addInstance(@RequestBody DataDTO dto) {

        Optional<Disk> unasignedDisks = diskService.findFirstByStatus(Disk.DiskStatus.UNASSIGNED);
        Disk disk;
        DiskRequestDTO diskRequest;
        if (unasignedDisks.isPresent()) {
            disk = unasignedDisks.get();
             diskRequest = new DiskRequestDTO(disk.getId(),disk.getSize(),disk.getType());
        } else {
            //Create a new disk ( As DTO doesnt exists,disk parameters aren't avaivable
            disk = diskService.buildDiskfromDTO(dto);
            diskRequest = new DiskRequestDTO(disk.getId(),disk.getSize(),disk.getType());
        }
        diskService.save(disk);
        Instance instance = instanceService.buildInstancefromDTO(dto);
        instance.setDisk(disk);
        instanceService.save(instance);
        messageService.sendDiskRequest(diskRequest);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(instance.getId()).toUri();
        return ResponseEntity.created(location).body(instance);
    }





}
