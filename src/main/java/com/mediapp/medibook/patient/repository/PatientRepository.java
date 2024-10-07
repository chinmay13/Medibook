package com.mediapp.medibook.patient.repository;

import com.mediapp.medibook.patient.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
    
}
