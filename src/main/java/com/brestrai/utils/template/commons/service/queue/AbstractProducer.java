package com.brestrai.utils.template.commons.service.queue;

import com.brestrai.utils.template.commons.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class AbstractProducer<T> extends AbstractService implements IProducer<T> {

    protected String exchangeName;

    protected String routingKey;

    protected RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(T message) {

    }
}
