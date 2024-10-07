package com.mediapp.medibook.usermanagement.service;

import com.mediapp.medibook.doctor.models.Doctor;
import com.mediapp.medibook.patient.model.Patient;


public interface UserManagementService {
    Doctor registerDoctor(Doctor doctor);
    Patient registerPatient(Patient patient);


}
