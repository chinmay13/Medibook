package com.mediapp.medibook.common.service;

import org.springframework.stereotype.Service;

@Service
public interface CommonServices {
    void sendEmail(String to, String subject, String body);
}
