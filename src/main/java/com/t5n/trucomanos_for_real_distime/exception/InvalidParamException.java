package com.t5n.trucomanos_for_real_distime.exception;

public class InvalidParamException extends Exception {

    private String message;

    public InvalidParamException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
