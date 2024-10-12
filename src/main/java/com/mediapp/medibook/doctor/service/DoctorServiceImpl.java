package com.mediapp.medibook.doctor.service;

import com.mediapp.medibook.doctor.dto.DoctorSearchDTO;
import com.mediapp.medibook.doctor.dto.DoctorViewDTO;
import com.mediapp.medibook.doctor.mapper.DoctorMapper;
import com.mediapp.medibook.doctor.models.Doctor;
import com.mediapp.medibook.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public List<DoctorViewDTO> findDoctorsByCriteria(DoctorSearchDTO doctorSearchDTO){
        List<Doctor> doctorsList = doctorRepository.searchDoctor(doctorSearchDTO);
        return doctorsList.stream()
                .map(doctorMapper::toDoctorViewDTO)
                .collect(Collectors.toList());
    }

    public List<DoctorViewDTO> fetchAllDoctors(){
        List<Doctor> doctorsList = doctorRepository.findAll();
        return doctorsList.stream()
                .map(doctorMapper::toDoctorViewDTO)
                .collect(Collectors.toList());
    }

    public DoctorViewDTO findDoctorByID(String doctorID){
        Doctor doctor = doctorRepository.findById(doctorID).orElse(null);
        if (doctor != null) {
            return doctorMapper.toDoctorViewDTO(doctor);
        }
        return null;
    }

    public DoctorViewDTO updateDoctor(String doctorID, Doctor updatedDoctor){
        Optional<Doctor> existingDoctorOpt = doctorRepository.findById(doctorID);
        if (existingDoctorOpt.isPresent()) {
            Doctor doctorToUpdate = existingDoctorOpt.get();
            doctorToUpdate.setFirstname(updatedDoctor.getFirstname());
            doctorToUpdate.setLastname(updatedDoctor.getLastname());
            doctorToUpdate.setEmail(updatedDoctor.getEmail());
            doctorToUpdate.setPhone(updatedDoctor.getPhone());
            doctorToUpdate.setAddress(updatedDoctor.getAddress());
            doctorToUpdate.setGender(updatedDoctor.getGender());
            doctorToUpdate.setSpecialization(updatedDoctor.getSpecialization());
            return doctorMapper.toDoctorViewDTO(doctorRepository.save(doctorToUpdate));
        }

        return null;
    }

    public boolean deleteDoctor(String doctorID){
        Optional<Doctor> existingDoctorOpt = doctorRepository.findById(doctorID);
        if (existingDoctorOpt.isPresent()) {
            doctorRepository.deleteById(doctorID);
            return true;
        }
        return false;
    }
}
