package com.mediapp.medibook.patient.mapper;
import com.mediapp.medibook.common.service.CommonServices;
import com.mediapp.medibook.patient.dto.PatientViewDTO;
import com.mediapp.medibook.patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PatientMapper {

    private final CommonServices commonServices;

    @Autowired
    public PatientMapper(CommonServices commonServices) {
        this.commonServices = commonServices;
    }

    public PatientViewDTO toPatientViewDTO(Patient patient) {
        PatientViewDTO dto = new PatientViewDTO();
        dto.setId(patient.getId());
        dto.setFirstname(patient.getFirstname());
        dto.setLastname(patient.getLastname());
        dto.setDob(patient.getDob());
        dto.setPhone(patient.getPhone());
        dto.setEmail(patient.getEmail());
        dto.setGender(patient.getGender());
        dto.setAddress(patient.getAddress());
        dto.setCreatedByDoctor(patient.isCreatedByDoctor());
        if(patient.getDob() != null) {
            dto.setAge(commonServices.calculateAge(patient.getDob()));
        }
        return dto;
    }
}
