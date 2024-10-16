package com.mediapp.medibook.patient.repository;

import com.mediapp.medibook.patient.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String>,
        PatientRepositoryCustom,
        PagingAndSortingRepository<Patient, String> {
    
}
