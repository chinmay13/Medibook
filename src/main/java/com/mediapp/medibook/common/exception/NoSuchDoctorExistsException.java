package com.mediapp.medibook.common.exception;

public class NoSuchDoctorExistsException extends RuntimeException {

    private String message;
    public NoSuchDoctorExistsException() {}
    public NoSuchDoctorExistsException(String message) {
        super(message);
        this.message = message;
    }
}
