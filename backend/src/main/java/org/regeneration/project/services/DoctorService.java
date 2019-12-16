package org.regeneration.project.services;


import org.regeneration.project.dto.CitizenAppointmentDto;
import org.regeneration.project.dto.DoctorAppointmentDto;
import org.regeneration.project.dto.DoctorSpecialityDto;
import org.regeneration.project.models.Doctor;
import org.regeneration.project.models.Speciality;
import org.regeneration.project.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorService(@Autowired DoctorRepository doctorRepository){this.doctorRepository = doctorRepository;}

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

    //UPDATE ONE USER IF EXISTS OR INSERT INTO DB
//    public Doctor updateDoctor(Doctor newDoctor, Long id){
//        return doctorRepository.findById(id)
//                .map(doctor-> {
//
//                })
//                .orElseGet(() -> {
//
//                });
//    }

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

}
