package es.urjc.disk_service.RabbitConfig;
import es.urjc.disk_service.DTO.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class DiskCreateListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = Config.DISK_REQUESTS_QUEUE)
    public void processDiskRequest(DiskRequestDTO diskRequest) {
        System.out.println("Processing disk request: " + diskRequest);

        sendDiskStatus(diskRequest, DiskStatusDTO.DiskStatus.REQUESTED);

        ScheduledExecutorService executor1 = Executors.newSingleThreadScheduledExecutor();
        executor1.schedule(() -> {
            sendDiskStatus(diskRequest, DiskStatusDTO.DiskStatus.INITIALIZED);
        }, 5, TimeUnit.SECONDS);

        ScheduledExecutorService executor2 = Executors.newSingleThreadScheduledExecutor();
        executor2.schedule(() -> {
            sendDiskStatus(diskRequest, DiskStatusDTO.DiskStatus.ASSIGNED);
        }, 15, TimeUnit.SECONDS);
    }

    private void sendDiskStatus(DiskRequestDTO diskRequest, DiskStatusDTO.DiskStatus status) {
        DiskStatusDTO statusUpdate = new DiskStatusDTO(
                diskRequest.getDiskId(),
                diskRequest.getDiskType(),
                status,
                diskRequest.getDiskSize()
        );

        rabbitTemplate.convertAndSend(Config.DISK_STATUSES_QUEUE, statusUpdate);
        System.out.println("Sent disk status update: " + statusUpdate);
    }
}
