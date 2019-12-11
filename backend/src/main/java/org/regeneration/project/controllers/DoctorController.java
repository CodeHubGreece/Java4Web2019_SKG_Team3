package org.regeneration.project.controllers;

import org.regeneration.project.models.Doctor;
import org.regeneration.project.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    public Optional<Doctor> getDoctor(@PathVariable Long id){
        return doctorService.getDoctor(id);
    }

    @PostMapping("/doctors")
    public void addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
    }

    @PutMapping("/doctors{id}")
    public void updateDoctor(@RequestBody Long id, @RequestBody Doctor doctor){
        doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping ("/doctors{id}")
    public void deleteDoctor(@RequestBody Long id){
        doctorService.deleteDoctor(id);
    }
}
