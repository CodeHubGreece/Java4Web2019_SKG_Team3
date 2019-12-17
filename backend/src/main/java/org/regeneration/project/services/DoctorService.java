package org.regeneration.project.services;


import org.regeneration.project.dto.*;
import org.regeneration.project.models.Doctor;
import org.regeneration.project.models.Speciality;
import org.regeneration.project.repositories.DoctorRepository;
import org.regeneration.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;
    private UserRepository userRepository;

    public DoctorService(@Autowired DoctorRepository doctorRepository, @Autowired UserRepository userRepository){
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    //GET ALL Doctors
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    //POST NEW USER
    public Doctor postNewDoctor(Doctor newDoctor){
        return doctorRepository.save(newDoctor);
    }

    //GET ONE USER
    public Optional<Doctor> getOneDoctor(Long id){
        return doctorRepository.findById(id);
    }

    public List<UserDoctorDto> getDoctorsBySpecialityId(Long id){
        List<UserDoctorDto> userDoctorDto = fetchDoctorbySpecialityJoin(id);
        return userDoctorDto;
    }

    //DELETE ONE USER
    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }

    public List<DoctorAppointmentDto> fetchEmpDeptDataInnerJoin(Long id){
        return doctorRepository.fetchEmpDeptDataLeftJoin(id);
    }

    public Long findDoctorIdByUserId(Long id){
        return doctorRepository.findDoctorIdByUserId(id);
    }

    public DoctorSpecialityDto fetchDoctorSpecialityInnerJoin(Long id){
        return doctorRepository.fetchDoctorSpecialityLeftJoin(id);
    }

    public List<UserDoctorDto> fetchDoctorbySpecialityJoin(Long id) {
        return doctorRepository.fetchDoctorbySpecialityLeftJoin(id);
    }

}
