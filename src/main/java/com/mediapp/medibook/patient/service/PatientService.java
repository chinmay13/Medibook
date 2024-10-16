package com.mediapp.medibook.patient.service;
import com.mediapp.medibook.patient.dto.PatientSearchDTO;
import com.mediapp.medibook.patient.dto.PatientViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    List<PatientViewDTO> fetchAllPatients(Pageable pageable);
    List<PatientViewDTO> findPatientsByCriteria(PatientSearchDTO patientSearchDTO, Pageable pageable);
    PatientViewDTO findPatientByID(String patientID);
    PatientViewDTO updatePatient(String patientID, PatientViewDTO patientViewDTO);
    boolean deletePatient(String patientID);
}
