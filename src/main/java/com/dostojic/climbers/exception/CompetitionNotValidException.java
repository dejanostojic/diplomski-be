package com.dostojic.climbers.exception;

public class CompetitionNotValidException extends RuntimeException {

    public CompetitionNotValidException() {
    }

    public CompetitionNotValidException(String message) {
        super(message);
    }

    public CompetitionNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompetitionNotValidException(Throwable cause) {
        super(cause);
    }

    public CompetitionNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
