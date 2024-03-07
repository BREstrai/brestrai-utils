package com.brestrai.utils.template.commons.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public abstract class AbstractService {

    protected Logger log;

    public AbstractService() {

        log = Logger.getLogger(this.getClass().getName());
    }
}
