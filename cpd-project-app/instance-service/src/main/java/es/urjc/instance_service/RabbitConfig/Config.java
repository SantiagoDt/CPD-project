package es.urjc.instance_service.RabbitConfig;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    public static final String INSTANCE_REQUESTS_QUEUE = "instance-requests";
    public static final String INSTANCE_STATUSES_QUEUE = "instance-statuses";

    @Bean
    public Queue instanceRequestsQueue() {
        return new Queue(INSTANCE_REQUESTS_QUEUE, true);
    }

    @Bean
    public Queue instanceStatusesQueue() {
        return new Queue(INSTANCE_STATUSES_QUEUE, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}