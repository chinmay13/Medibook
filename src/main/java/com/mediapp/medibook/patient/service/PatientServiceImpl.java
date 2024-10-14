package com.mediapp.medibook.patient.service;
import com.mediapp.medibook.patient.dto.PatientViewDTO;
import com.mediapp.medibook.patient.mapper.PatientMapper;
import com.mediapp.medibook.patient.model.Patient;
import com.mediapp.medibook.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private PatientRepository patientRepository;


    public List<PatientViewDTO> fetchAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream()
                .map(patientMapper::toPatientViewDTO)
                .collect(Collectors.toList());
    }

}
