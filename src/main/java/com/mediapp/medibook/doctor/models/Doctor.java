package com.mediapp.medibook.doctor.models;

import com.mediapp.medibook.common.models.Gender;
import com.mediapp.medibook.common.models.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "doctors")
public class Doctor {
    @Id
    private String id;

    @NotNull(message = "First Name is required")
    @Size(min = 2, max=100, message = "First Name must be between 2 and 100 characters")
    private String firstname;

    @NotNull(message = "Last Name is required")
    @Size(min = 2, max=100, message = "Last Name must be between 2 and 100 characters")
    private String lastname;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Phone is required")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 digits")
    private String phone;

    @NotNull(message = "Address is required")
    private Address address;

    private Gender gender;
    private String specialization;
    private List<String> appointments;

    public Doctor(String firstname,
                  String lastname,
                  String email,
                  String phone,
                  Address address,
                  Gender gender,
                  String specialization,
                  List<String> appointments) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.specialization = specialization;
        this.appointments = appointments;
    }
}
