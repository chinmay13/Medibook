package com.mediapp.medibook.doctor.repository;

import com.mediapp.medibook.doctor.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String>, DoctorRepositoryCustom, PagingAndSortingRepository<Doctor, String> {
}
