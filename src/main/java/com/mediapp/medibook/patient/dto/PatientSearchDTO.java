package com.mediapp.medibook.patient.dto;

import lombok.Data;

@Data
public class PatientSearchDTO {
    private String firstname;
    private String lastname;
    private String gender;
    private String phone;
    private String email;
}
