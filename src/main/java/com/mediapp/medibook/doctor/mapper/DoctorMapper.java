package com.mediapp.medibook.doctor.mapper;

import com.mediapp.medibook.doctor.dto.DoctorViewDTO;
import com.mediapp.medibook.doctor.models.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public DoctorViewDTO toDoctorViewDTO(Doctor doctor) {
        DoctorViewDTO dto = new DoctorViewDTO();
        dto.setId(doctor.getId());
        dto.setFirstname(doctor.getFirstname());
        dto.setLastname(doctor.getLastname());
        dto.setEmail(doctor.getEmail());
        dto.setPhone(doctor.getPhone());
        dto.setAddress(doctor.getAddress());
        dto.setGender(doctor.getGender());
        dto.setSpecialization(doctor.getSpecialization());
        return dto;
    }

    public Doctor toDoctor(DoctorViewDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setId(dto.getId());
        doctor.setFirstname(dto.getFirstname());
        doctor.setLastname(dto.getLastname());
        doctor.setEmail(dto.getEmail());
        doctor.setPhone(dto.getPhone());
        doctor.setAddress(dto.getAddress());
        doctor.setGender(dto.getGender());
        doctor.setSpecialization(dto.getSpecialization());
        return doctor;
    }

}
