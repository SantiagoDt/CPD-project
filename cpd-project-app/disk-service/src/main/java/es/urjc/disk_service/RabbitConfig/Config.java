package es.urjc.disk_service.RabbitConfig;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    public static final String DISK_REQUESTS_QUEUE = "disk-requests";
    public static final String DISK_STATUSES_QUEUE = "disk-statuses";

    @Bean
    public Queue diskRequestsQueue() {
        return new Queue(DISK_REQUESTS_QUEUE, true);
    }

    @Bean
    public Queue diskStatusesQueue() {
        return new Queue(DISK_STATUSES_QUEUE, true);
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
