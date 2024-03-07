package com.brestrai.utils.template.commons.service.queue;

import com.brestrai.utils.template.commons.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class AbstractConsumer<T> extends AbstractService implements IConsumer<T> {


    /*
     * Anotar a implementação com @RabbitListener(queues = "${rabbitmq.queue.name}")
     * */

    @Override
    public void receiveMessage(T message) {

    }
}
