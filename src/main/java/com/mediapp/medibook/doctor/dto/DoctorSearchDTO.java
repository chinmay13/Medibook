package com.mediapp.medibook.doctor.dto;

import lombok.Data;

@Data
public class DoctorSearchDTO {
    private String firstname;
    private String lastname;
    private String specialization;
    private String gender;
    private String phone;
    private String email;
}
