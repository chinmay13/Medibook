package com.mediapp.medibook.patient.controller;

import com.mediapp.medibook.patient.model.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @GetMapping("/find")
    public String findPatientById() {
        return "HELLO WORLD";
    }

}
