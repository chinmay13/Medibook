package com.mediapp.medibook.doctor.repository;

import com.mediapp.medibook.doctor.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String>, DoctorRepositoryCustom {
}
