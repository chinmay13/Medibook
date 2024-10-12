package com.mediapp.medibook.doctor.dto;

import com.mediapp.medibook.common.models.Address;
import com.mediapp.medibook.common.models.Gender;
import lombok.Data;

@Data
public class DoctorViewDTO {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private Address address;
    private Gender gender;
    private String specialization;
}
