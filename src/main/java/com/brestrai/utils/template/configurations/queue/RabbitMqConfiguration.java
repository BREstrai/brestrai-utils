package com.brestrai.utils.template.configurations.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class RabbitMqConfiguration {


    public abstract String getQueue();

    public abstract String getExchange();

    public abstract String getRoutingKey();

    @Bean
    public Queue declareQueue() {
        return new Queue(this.getQueue());
    }

    @Bean
    public TopicExchange getQueueName() {
        return new TopicExchange(getExchange());
    }

    @Bean
    public Binding declareBinding() {
        return BindingBuilder.bind(declareQueue())
                .to(getQueueName())
                .with(getRoutingKey());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate();
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}
