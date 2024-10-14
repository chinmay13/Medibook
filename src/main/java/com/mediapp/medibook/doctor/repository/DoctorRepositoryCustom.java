package com.mediapp.medibook.doctor.repository;

import com.mediapp.medibook.doctor.dto.DoctorSearchDTO;
import com.mediapp.medibook.doctor.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorRepositoryCustom {
    Page<Doctor> searchDoctor(DoctorSearchDTO doctorSearchDTO, Pageable pageable);
}
