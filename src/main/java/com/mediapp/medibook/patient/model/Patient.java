package com.mediapp.medibook.patient.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private String address;
    private String email;
    private List<String> appointments;



}
