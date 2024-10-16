package com.mediapp.medibook.patient.repository;

import com.mediapp.medibook.patient.dto.PatientSearchDTO;
import com.mediapp.medibook.patient.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientRepositoryCustom {
    Page<Patient> searchPatient(PatientSearchDTO patientSearchDTO, Pageable pageable);
}
