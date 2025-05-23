package es.urjc.api_service.Service;

import es.urjc.api_service.Dto.DiskRequestDTO;
import es.urjc.api_service.Dto.InstanceRequestDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDiskRequest(DiskRequestDTO diskRequest){

        rabbitTemplate.convertAndSend("disk-requests", diskRequest);

    }
    public void sendInstanceRequest(InstanceRequestDTO instanceRequest){
        rabbitTemplate.convertAndSend("instance-requests", instanceRequest);
    }


}
