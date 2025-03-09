package com.t5n.trucomanos_for_real_distime.exception;

public class InvalidGameException extends Exception {
    private String message;

    public InvalidGameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
