package es.urjc.instance_service.RabbitConfig;

import es.urjc.instance_service.RabbitConfig.Config;
import es.urjc.instance_service.DTO.InstanceRequestDTO;
import es.urjc.instance_service.DTO.InstanceStatusDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class InstanceCreateListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final Random random = new Random();

    @RabbitListener(queues = Config.INSTANCE_REQUESTS_QUEUE)
    public void processInstanceRequest(InstanceRequestDTO instanceRequest) {
        System.out.println("Processing instance request: " + instanceRequest);

        sendInstanceStatus(instanceRequest, InstanceStatusDTO.InstanceStatus.STARTING);

        ScheduledExecutorService executor1 = Executors.newSingleThreadScheduledExecutor();
        executor1.schedule(() -> {
            sendInstanceStatus(instanceRequest, InstanceStatusDTO.InstanceStatus.INITIALIZING);
        }, 5, TimeUnit.SECONDS);

        ScheduledExecutorService executor2 = Executors.newSingleThreadScheduledExecutor();
        executor2.schedule(() -> {
            sendInstanceStatus(instanceRequest, InstanceStatusDTO.InstanceStatus.ASSIGNING_IP);
        }, 15, TimeUnit.SECONDS);

        ScheduledExecutorService executor3 = Executors.newSingleThreadScheduledExecutor();
        executor3.schedule(() -> {
            sendInstanceStatusWithIP(instanceRequest, InstanceStatusDTO.InstanceStatus.RUNNING);
        }, 25, TimeUnit.SECONDS);
    }

    private void sendInstanceStatus(InstanceRequestDTO instanceRequest, InstanceStatusDTO.InstanceStatus status) {
        InstanceStatusDTO statusUpdate = new InstanceStatusDTO(
                instanceRequest.getInstanceId(),
                status,
                null
        );
        rabbitTemplate.convertAndSend(Config.INSTANCE_STATUSES_QUEUE, statusUpdate);
        System.out.println("Sent instance status update: " + statusUpdate);
    }

    private void sendInstanceStatusWithIP(InstanceRequestDTO instanceRequest, InstanceStatusDTO.InstanceStatus status) {
        // Generate IP random between 192.168.1.2 and 192.168.1.254
        String ip = generateRandomIP();
        InstanceStatusDTO statusUpdate = new InstanceStatusDTO(
                instanceRequest.getInstanceId(),
                status,
                ip
        );
        rabbitTemplate.convertAndSend(Config.INSTANCE_STATUSES_QUEUE, statusUpdate);
        System.out.println("Sent instance status update: " + statusUpdate);
    }

    private String generateRandomIP() {
        int lastOctet = random.nextInt(253) + 2;
        return "192.168.1." + lastOctet;
    }

}
