package com.brestrai.utils.commons.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public abstract class AbstractService {

    private Logger log;

    public AbstractService() {

        log = Logger.getLogger(this.getClass().getName());
    }

    protected void logInfo(String msg) {

        log.info(msg);
    }

    protected void logWarn(String msg) {

        log.warning(msg);
    }
}
