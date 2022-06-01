package com.dev.deploymentjournal.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
public class DateFormatException extends RuntimeException {

    public DateFormatException(String message) {
        super(message);
    }
}
