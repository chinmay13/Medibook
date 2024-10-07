package com.mediapp.medibook.usermanagement.service;

import com.mediapp.medibook.doctor.models.Doctor;
import com.mediapp.medibook.patient.model.Patient;
import org.springframework.stereotype.Service;


public interface UserManagementService {
    public Doctor registerDoctor(Doctor doctor);
    public void registerPatient(Patient patient);


}
