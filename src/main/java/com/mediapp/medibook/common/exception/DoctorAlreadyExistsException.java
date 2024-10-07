package com.mediapp.medibook.common.exception;

public class DoctorAlreadyExistsException extends RuntimeException{
    private String message;

    public DoctorAlreadyExistsException() {}

    public DoctorAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
