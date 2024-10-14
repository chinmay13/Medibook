package com.mediapp.medibook.doctor.repository;

import com.mediapp.medibook.common.exception.InvalidSearchCriteriaException;
import com.mediapp.medibook.doctor.dto.DoctorSearchDTO;
import com.mediapp.medibook.doctor.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepositoryCustomImpl implements DoctorRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    @Autowired
    DoctorRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Page<Doctor> searchDoctor(DoctorSearchDTO doctorSearchDTO, Pageable pageable) {

        validateDoctorSearchDTO(doctorSearchDTO);

        Query query = new Query();

        if(doctorSearchDTO.getFirstname() != null){
            query.addCriteria(Criteria.where("firstname").regex(".*" + doctorSearchDTO.getFirstname() + ".*", "i"));
        }

        if(doctorSearchDTO.getLastname() != null){
            query.addCriteria(Criteria.where("lastname").regex(".*" + doctorSearchDTO.getLastname() + ".*", "i"));
        }

        if(doctorSearchDTO.getEmail() != null){
            query.addCriteria(Criteria.where("email").regex(".*" + doctorSearchDTO.getEmail() + ".*", "i"));
        }

        if(doctorSearchDTO.getPhone() != null){
            query.addCriteria(Criteria.where("phone").is(doctorSearchDTO.getPhone()));
        }

        if(doctorSearchDTO.getSpecialization() != null){
            query.addCriteria(Criteria.where("specialization").regex(doctorSearchDTO.getSpecialization(), "i"));
        }

        if(doctorSearchDTO.getGender() != null){
            query.addCriteria(Criteria.where("gender").is(doctorSearchDTO.getGender()));
        }
        query.with(pageable);

        List<Doctor> doctorsList = mongoTemplate.find(query, Doctor.class);

        long total = mongoTemplate.count(query.skip(-1).limit(-1), Doctor.class);

        return new PageImpl<>(doctorsList, pageable, total);
    }

    private void validateDoctorSearchDTO(DoctorSearchDTO doctorSearchDTO) {
        if (doctorSearchDTO.getFirstname() == null && doctorSearchDTO.getLastname() == null &&
                doctorSearchDTO.getSpecialization() == null && doctorSearchDTO.getPhone() == null &&
                doctorSearchDTO.getGender()==null && doctorSearchDTO.getEmail() == null) {
            throw new InvalidSearchCriteriaException("At least one search criteria must be provided.");
        }
    }
}
