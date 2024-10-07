package com.mediapp.medibook.usermanagement.service;

import com.mediapp.medibook.doctor.models.Doctor;
import com.mediapp.medibook.doctor.repository.DoctorRepository;
import com.mediapp.medibook.patient.model.Patient;
import com.mediapp.medibook.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImplementation implements UserManagementService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    UserManagementServiceImplementation(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;

    }

    @Override
    public Doctor registerDoctor(Doctor doctor) {
         return doctorRepository.save(doctor);
    }

    @Override
    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }


}
