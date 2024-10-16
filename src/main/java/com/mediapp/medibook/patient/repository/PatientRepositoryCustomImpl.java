package com.mediapp.medibook.patient.repository;

import com.mediapp.medibook.common.exception.InvalidSearchCriteriaException;
import com.mediapp.medibook.patient.dto.PatientSearchDTO;
import com.mediapp.medibook.patient.model.Patient;
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
public class PatientRepositoryCustomImpl implements PatientRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public PatientRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Page<Patient> searchPatient(PatientSearchDTO patientSearchDTO, Pageable pageable) {

        validatePatientSearchDTO(patientSearchDTO);

        Query query = new Query();

        if(patientSearchDTO.getFirstname() != null){
            query.addCriteria(Criteria.where("firstname").regex(".*" + patientSearchDTO.getFirstname() + ".*", "i"));
        }

        if(patientSearchDTO.getLastname() != null){
            query.addCriteria(Criteria.where("lastname").regex(".*" + patientSearchDTO.getLastname() + ".*", "i"));
        }

        if(patientSearchDTO.getEmail() != null){
            query.addCriteria(Criteria.where("email").regex(".*" + patientSearchDTO.getEmail() + ".*", "i"));
        }

        if(patientSearchDTO.getPhone() != null){
            query.addCriteria(Criteria.where("phone").is(patientSearchDTO.getPhone()));
        }

        if(patientSearchDTO.getGender() != null){
            query.addCriteria(Criteria.where("gender").is(patientSearchDTO.getGender()));
        }

        query.with(pageable);

        List<Patient> patients = mongoTemplate.find(query, Patient.class);

        long total = mongoTemplate.count(query.skip(-1).limit(-1), Patient.class);

        return new PageImpl<>(patients, pageable, total);
    }

    private void validatePatientSearchDTO(PatientSearchDTO patientSearchDTO) {
        if (patientSearchDTO.getFirstname() == null && patientSearchDTO.getLastname() == null &&
                patientSearchDTO.getPhone() == null && patientSearchDTO.getGender()==null &&
                patientSearchDTO.getEmail() == null) {
            throw new InvalidSearchCriteriaException("At least one search criteria must be provided.");
        }
    }
}
