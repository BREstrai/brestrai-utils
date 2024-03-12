package com.brestrai.utils.commons.service.queue;

public interface IProducer<T> {


    public void sendMessage(T message);
}
