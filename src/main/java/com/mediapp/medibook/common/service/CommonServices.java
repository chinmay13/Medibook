package com.mediapp.medibook.common.service;

public interface CommonServices {
    void sendEmail(String to, String subject, String body);
    int calculateAge(String dob);
}
