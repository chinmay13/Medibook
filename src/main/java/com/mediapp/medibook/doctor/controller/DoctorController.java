package com.mediapp.medibook.doctor.controller;

import com.mediapp.medibook.doctor.models.Doctor;
import com.mediapp.medibook.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{doctorID}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable int doctorID) {
        Doctor doctor = null;
        // todo: implement doctor put mapping service
        return ResponseEntity.ok(doctor);
    }

    @PutMapping("/{doctorID}")
    public ResponseEntity<Void> updateDoctor(@PathVariable int doctorID, @RequestBody Doctor doctor) {
        // todo: implement doctor put mapping service
        return ResponseEntity.ok().build();
    }



    @GetMapping("/findall")
    public ResponseEntity<List<Doctor>> findAllDoctors(){
        return ResponseEntity.ok(new ArrayList<>());
    }

}
