package com.mediapp.medibook.doctor.service;

import com.mediapp.medibook.doctor.dto.DoctorSearchDTO;
import com.mediapp.medibook.doctor.dto.DoctorViewDTO;
import com.mediapp.medibook.doctor.models.Doctor;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface DoctorService {
    List<DoctorViewDTO> findDoctorsByCriteria(DoctorSearchDTO doctorSearchDTO, Pageable pageable);
    List<DoctorViewDTO> fetchAllDoctors(Pageable pageable);
    DoctorViewDTO findDoctorByID(String doctorID);
    DoctorViewDTO updateDoctor(String doctorID, Doctor doctor);
    boolean deleteDoctor(String doctorID);
}
