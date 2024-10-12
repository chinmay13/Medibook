package com.mediapp.medibook.doctor.controller;

import com.mediapp.medibook.doctor.dto.DoctorSearchDTO;
import com.mediapp.medibook.doctor.dto.DoctorViewDTO;
import com.mediapp.medibook.doctor.models.Doctor;
import com.mediapp.medibook.doctor.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{doctorID}")
    public ResponseEntity<DoctorViewDTO> findDoctorByID(@PathVariable String doctorID) {
        DoctorViewDTO doctor = doctorService.findDoctorByID(doctorID);
        if(doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<DoctorViewDTO>> fetchAllDoctors(Pageable pageable) {
        List<DoctorViewDTO> doctors = doctorService.fetchAllDoctors(pageable);
        if (doctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctors);
    }


    @PostMapping("/findByCriteria")
    public ResponseEntity<List<DoctorViewDTO>> findDoctorsByCriteria(@RequestBody DoctorSearchDTO doctorSearchDTO,
                                                                     Pageable pageable) {
        List<DoctorViewDTO> doctors = doctorService.findDoctorsByCriteria(doctorSearchDTO, pageable);
        if (doctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctors);
    }

    @PutMapping("/{doctorID}")
    public ResponseEntity<String> updateDoctor(@PathVariable String doctorID, @Valid @RequestBody Doctor doctor) {
        DoctorViewDTO  updatedDoctor = doctorService.updateDoctor(doctorID, doctor);
        if(updatedDoctor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        return ResponseEntity.ok("Doctor updated successfully");
    }

    @DeleteMapping("/{doctorID}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String doctorID) {
        if(doctorService.deleteDoctor(doctorID)){
            return ResponseEntity.ok("Doctor deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
    }
}
