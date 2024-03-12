package com.brestrai.utils.commons.service.queue;

public interface IConsumer<T> {


    public void receiveMessage(T message);
}
