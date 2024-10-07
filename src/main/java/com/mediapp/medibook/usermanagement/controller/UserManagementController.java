package com.mediapp.medibook.usermanagement.controller;

import com.mediapp.medibook.doctor.models.Doctor;
import com.mediapp.medibook.patient.model.Patient;
import com.mediapp.medibook.usermanagement.service.UserManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserManagementController {

    UserManagementService userManagementService;

    @Autowired
    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @PostMapping("/register/doctor")
    public ResponseEntity<String> registerDoctor(@Valid @RequestBody Doctor doctor,
                                                 UriComponentsBuilder ucb){
        Doctor newDoctor = userManagementService.registerDoctor(doctor);
        URI locationOfNewDoctorObject = ucb.path("/api/doctor/{id}").buildAndExpand(newDoctor.getId()).toUri();
        return ResponseEntity.created(locationOfNewDoctorObject).body("Doctor Created Successfully");

    }

    @PostMapping("/register/patient")
    public ResponseEntity<String> registerPatient(@Valid @RequestBody Patient patient){
        userManagementService.registerPatient(patient);

        return ResponseEntity.ok("Patient registered successfully");
    }
}
