package com.dostojic.climbers.rest.bff.config;

import org.springframework.http.HttpStatus;

public class ClimberException extends RuntimeException {
    HttpStatus status;
    String message;

    public ClimberException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
