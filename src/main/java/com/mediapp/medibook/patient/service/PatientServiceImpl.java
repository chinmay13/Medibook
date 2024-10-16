package com.mediapp.medibook.patient.service;

import com.mediapp.medibook.patient.dto.PatientSearchDTO;
import com.mediapp.medibook.patient.dto.PatientViewDTO;
import com.mediapp.medibook.patient.mapper.PatientMapper;
import com.mediapp.medibook.patient.model.Patient;
import com.mediapp.medibook.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientMapper patientMapper, PatientRepository patientRepository) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientViewDTO> fetchAllPatients(Pageable pageable) {
        Page<Patient> patientList = patientRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(
                                Sort.Order.asc("lastName"),
                                Sort.Order.asc("firstName"))
                        )
                )
        );
        return patientList.getContent().stream()
                .map(patientMapper::toPatientViewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientViewDTO> findPatientsByCriteria(PatientSearchDTO patientSearchDTO, Pageable pageable) {
        Page<Patient> patientList = patientRepository.searchPatient(patientSearchDTO,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(
                                Sort.Order.asc("lastName"),
                                Sort.Order.asc("firstName"))
                        )
                ));

        return patientList.getContent().stream()
                .map(patientMapper::toPatientViewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientViewDTO findPatientByID(String patientID) {
        Patient patient = patientRepository.findById(patientID).orElse(null);
        if (patient == null) {
            return null;
        }
        return patientMapper.toPatientViewDTO(patient);
    }

    @Override
    public PatientViewDTO updatePatient(String patientID, PatientViewDTO updatedPatient) {
        Optional<Patient> patientOptional = patientRepository.findById(patientID);
        if(patientOptional.isPresent()) {
            Patient patientToUpdate = patientOptional.get();
            patientToUpdate.setFirstname(updatedPatient.getFirstname());
            patientToUpdate.setLastname(updatedPatient.getLastname());
            patientToUpdate.setDob(updatedPatient.getDob());
            patientToUpdate.setPhone(updatedPatient.getPhone());
            patientToUpdate.setEmail(updatedPatient.getEmail());
            patientToUpdate.setGender(updatedPatient.getGender());
            patientToUpdate.setAddress(updatedPatient.getAddress());
            patientToUpdate.setCreatedByDoctor(updatedPatient.isCreatedByDoctor());
            return patientMapper.toPatientViewDTO(patientRepository.save(patientToUpdate));
        }
        return null;
    }

    @Override
    public boolean deletePatient(String patientID) {
        Optional<Patient> patientOptional = patientRepository.findById(patientID);
        if(patientOptional.isPresent()) {
            patientRepository.deleteById(patientID);
            return true;
        }
        return false;
    }
}
