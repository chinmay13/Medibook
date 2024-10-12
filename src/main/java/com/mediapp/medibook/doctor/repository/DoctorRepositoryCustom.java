package com.mediapp.medibook.doctor.repository;

import com.mediapp.medibook.doctor.dto.DoctorSearchDTO;
import com.mediapp.medibook.doctor.models.Doctor;

import java.util.List;

public interface DoctorRepositoryCustom {
    List<Doctor> searchDoctor(DoctorSearchDTO doctorSearchDTO);
}
