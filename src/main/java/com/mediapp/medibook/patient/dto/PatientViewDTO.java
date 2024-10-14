package com.mediapp.medibook.patient.dto;

import com.mediapp.medibook.common.models.Address;
import com.mediapp.medibook.common.models.Gender;

import lombok.Data;

import java.util.List;

@Data
public class PatientViewDTO {
    private String id;
    private String firstname;
    private String lastname;
    private String dob;
    private int age;
    private String phone;
    private String email;
    private Gender gender;
    private Address address;
    private List<String> appointments;
    private boolean isCreatedByDoctor;
}

