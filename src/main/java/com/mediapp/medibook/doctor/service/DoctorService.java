package com.mediapp.medibook.doctor.service;

import com.mediapp.medibook.doctor.dto.DoctorSearchDTO;
import com.mediapp.medibook.doctor.dto.DoctorViewDTO;
import com.mediapp.medibook.doctor.models.Doctor;


import java.util.List;

public interface DoctorService {
    List<DoctorViewDTO> findDoctorsByCriteria(DoctorSearchDTO doctorSearchDTO);
    List<DoctorViewDTO> fetchAllDoctors();
    DoctorViewDTO findDoctorByID(String doctorID);
    DoctorViewDTO updateDoctor(String doctorID, Doctor doctor);
    boolean deleteDoctor(String doctorID);
}
