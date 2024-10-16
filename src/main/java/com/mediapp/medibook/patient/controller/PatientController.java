package com.mediapp.medibook.patient.controller;

import com.mediapp.medibook.patient.dto.PatientSearchDTO;
import com.mediapp.medibook.patient.dto.PatientViewDTO;
import com.mediapp.medibook.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{patientID}")
    public ResponseEntity<PatientViewDTO> findPatientById(@PathVariable String patientID) {
        PatientViewDTO patient = patientService.findPatientByID(patientID);
        if (patient == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<PatientViewDTO>> fetchAllPatients(Pageable pageable) {
        List<PatientViewDTO> patients = patientService.fetchAllPatients(pageable);
        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping("/findByCriteria")
    public ResponseEntity<List<PatientViewDTO>> findPatientByCriteria(@RequestBody PatientSearchDTO patientSearchDTO,
                                                                      Pageable pageable){
        List<PatientViewDTO> patients = patientService.findPatientsByCriteria(patientSearchDTO, pageable);
        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(patients);
    }

    @PutMapping("/{patientID}")
    public ResponseEntity<String> updatePatient(@PathVariable String patientID,
                                                @Valid @RequestBody PatientViewDTO patientViewDTO) {
        PatientViewDTO updatedPatient = patientService.updatePatient(patientID, patientViewDTO);
        if(updatedPatient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
        return ResponseEntity.ok("Patient updated successfully");
    }

    @DeleteMapping("/{patientID}")
    public ResponseEntity<String> deletePatient(@PathVariable String patientID) {
        if(patientService.deletePatient(patientID)){
            return ResponseEntity.ok("Patient deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
    }

}
