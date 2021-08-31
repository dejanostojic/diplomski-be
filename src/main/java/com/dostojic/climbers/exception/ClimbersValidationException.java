package com.dostojic.climbers.exception;

public class ClimbersValidationException extends RuntimeException {

    public ClimbersValidationException() {
    }

    public ClimbersValidationException(String message) {
        super(message);
    }

    public ClimbersValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClimbersValidationException(Throwable cause) {
        super(cause);
    }

    public ClimbersValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
