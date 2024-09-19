package com.brestrai.utils.commons.exception;

import com.brestrai.utils.commons.domain.response.ErrorResponse;
import lombok.Getter;

@Getter
public abstract class AbstractException extends RuntimeException {

    private ErrorResponse errorResponse;

    public AbstractException(String msg) {

        super(msg);
    }

    public AbstractException(String msg, ErrorResponse errorResponse) {

        super(msg);
        this.errorResponse = errorResponse;
    }
}
