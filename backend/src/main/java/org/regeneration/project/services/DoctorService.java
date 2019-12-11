package org.regeneration.project.services;

import org.regeneration.project.models.Doctor;
import org.regeneration.project.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = new ArrayList<>();
        doctorRepository.findAll().forEach(doctors::add);
        return doctors;
    }

    public Optional<Doctor> getDoctor(Long id){
        return doctorRepository.findById(id);
    }

    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public void updateDoctor(Long id, Doctor doctor){
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }
}
