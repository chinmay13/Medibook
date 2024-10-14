package com.mediapp.medibook.patient.model;

import com.mediapp.medibook.common.models.Address;
import com.mediapp.medibook.common.models.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "patients")
public class Patient {
    @Id
    private String id;

    @NotNull(message = "First Name is required")
    @Size(min = 2, max=30, message = "First Name must be between 2 and 30 characters")
    private String firstName;

    @NotNull(message = "Last Name is required")
    @Size(min = 2, max=30, message = "Last Name must be between 2 and 30 characters")
    private String lastName;

    @Past(message = "Date of Birth must be a past date")
    private String dob;

    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 digits")
    private String phone;

    @Email(message = "Email should be valid")
    private String email;

    private Gender gender;
    private Address address;
    private List<String> appointments;
    private boolean isCreatedByDoctor;

}
