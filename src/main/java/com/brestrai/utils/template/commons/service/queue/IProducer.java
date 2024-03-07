package com.brestrai.utils.template.commons.service.queue;

public interface IProducer<T> {


    public void sendMessage(T message);
}
