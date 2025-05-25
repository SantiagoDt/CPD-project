package es.urjc.api_service.Rabbit;

import es.urjc.api_service.Dto.DiskStatusDTO;
import es.urjc.api_service.Dto.InstanceRequestDTO;
import es.urjc.api_service.Model.Disk;
import es.urjc.api_service.Model.Instance;
import es.urjc.api_service.Service.DiskStorageService;
import es.urjc.api_service.Service.MessageProducerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiskStatusListener {

    @Autowired
    DiskStorageService diskService;
    @Autowired
    MessageProducerService messageService;

    @RabbitListener(queues = "disk-statuses", ackMode = "AUTO")
    public void process(DiskStatusDTO statusDTO) {

        Optional<Disk> diskOpt = diskService.findById(statusDTO.getDiskId());
        if (diskOpt.isPresent()) {
            Disk disk = diskOpt.get();
            disk.setStatus(statusDTO.getStatus());
            diskService.save(disk);
            if (disk.getStatus() == Disk.DiskStatus.ASSIGNED) {
                Instance instance = disk.getInstance();
                InstanceRequestDTO instanceRequestDTO = new InstanceRequestDTO(instance.getId(), instance.getName(),
                        instance.getCores(), instance.getMemory());
                messageService.sendInstanceRequest(instanceRequestDTO);
            }
        } else {
            System.err.println("Disk with ID " + statusDTO.getDiskId() + " not found.");
        }

    }

}
