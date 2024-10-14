package com.mediapp.medibook.patient.controller;
import com.mediapp.medibook.patient.dto.PatientViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.mediapp.medibook.patient.service.PatientService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/find")
    public String findPatientById() {
        return "HELLO WORLD";
    }

    @GetMapping("/findall")
    public ResponseEntity<List<PatientViewDTO>> fetchAllDoctors(){
        List<PatientViewDTO> patients = patientService.fetchAllPatients();
        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
