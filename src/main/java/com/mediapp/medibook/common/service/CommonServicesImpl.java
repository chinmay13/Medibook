package com.mediapp.medibook.common.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class CommonServicesImpl implements CommonServices {
    public void sendEmail(String to, String subject, String body){

    }

    @Override
    public int calculateAge(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        LocalDate currentDate = LocalDate.now();

        if ((birthDate.isBefore(currentDate) || birthDate.isEqual(currentDate))) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            throw new IllegalArgumentException("Invalid date of birth.");
        }
    }
}
