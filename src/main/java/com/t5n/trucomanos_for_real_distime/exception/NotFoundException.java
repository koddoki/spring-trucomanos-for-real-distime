package com.t5n.trucomanos_for_real_distime.exception;

public class NotFoundException extends Exception {
    private String message;

    public NotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
