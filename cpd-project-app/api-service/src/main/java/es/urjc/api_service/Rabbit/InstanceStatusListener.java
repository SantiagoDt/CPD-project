package es.urjc.api_service.Rabbit;

import es.urjc.api_service.Dto.InstanceStatusDTO;
import es.urjc.api_service.Model.Instance;
import es.urjc.api_service.Service.InstanceStorageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstanceStatusListener {
    @Autowired
    InstanceStorageService instanceService;

    @RabbitListener(queues = "instance-statuses", ackMode = "AUTO")
    public void receiveMessage(InstanceStatusDTO status) {
        Optional<Instance> instanceOpt = instanceService.findById(status.getInstanceId());
        if (instanceOpt.isPresent()) {
            Instance instance = instanceOpt.get();
            instance.setStatus(status.getStatus());
            instance.setIpAddress(status.getIp());
            instanceService.save(instance);
        }
    }

}
