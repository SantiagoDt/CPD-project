package es.urjc.api_service.Controller;

import es.urjc.api_service.Model.Disk;
import es.urjc.api_service.Service.DiskStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/disks")
public class DiskController {

    @Autowired
    private DiskStorageService diskService;

    @GetMapping("/")
    public Page<Disk> getDisks(Pageable pageable) {
        return diskService.findAll(pageable); // todos
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disk> getDisk(@PathVariable Long id) {
        Optional<Disk> diskOpt = diskService.findById(id);
        return ResponseEntity.of(diskOpt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Disk> deleteDisk(@PathVariable Long id) {
        Optional<Disk> diskOpt = diskService.findById(id);
        if (diskOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Disk disk = diskOpt.get();
        if (disk.getStatus() == Disk.DiskStatus.UNASSIGNED) {
            diskService.deleteById(disk.getId());
            return ResponseEntity.ok(disk);
        } else {
            return ResponseEntity.badRequest().body(disk);
        }
    }
}
