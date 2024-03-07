package com.brestrai.utils.template.commons.service.queue;

public interface IConsumer<T> {


    public void receiveMessage(T message);
}
