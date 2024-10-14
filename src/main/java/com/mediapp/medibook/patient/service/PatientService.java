package com.mediapp.medibook.patient.service;
import com.mediapp.medibook.patient.dto.PatientViewDTO;
import java.util.List;




public interface PatientService {

    List<PatientViewDTO> fetchAllPatients();
}
