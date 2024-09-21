package com.brestrai.utils.commons.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private HttpStatus statusCode;

    private String message;

}
