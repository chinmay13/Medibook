package com.mediapp.medibook.patient.mapper;
import com.mediapp.medibook.patient.dto.PatientViewDTO;
import com.mediapp.medibook.patient.model.Patient;
import org.springframework.stereotype.Component;


@Component
public class PatientMapper {

    public PatientViewDTO toPatientViewDTO(Patient patient) {
        PatientViewDTO dto = new PatientViewDTO();
        dto.setId(patient.getId());
        dto.setFirstname(patient.getFirstName());
        dto.setLastname(patient.getLastName());
        dto.setDob(patient.getDob());
        dto.setPhone(patient.getPhone());
        dto.setEmail(patient.getEmail());
        dto.setGender(patient.getGender());
        dto.setAddress(patient.getAddress());
        dto.setAppointments(patient.getAppointments());
        dto.setCreatedByDoctor(patient.isCreatedByDoctor());

        return dto;
    }
}
