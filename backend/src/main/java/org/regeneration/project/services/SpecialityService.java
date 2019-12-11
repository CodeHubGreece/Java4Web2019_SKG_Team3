package org.regeneration.project.services;

import org.regeneration.project.models.Speciality;
import org.regeneration.project.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    public List<Speciality> getAllSpecialities(){
        List<Speciality> specialities = new ArrayList<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    public Optional<Speciality> getSpeciality(Long id){
        return specialityRepository.findById(id);
    }

    public void addSpeciality(Speciality speciality){
        specialityRepository.save(speciality);
    }

    public void updateSpeciality(Long id, Speciality speciality){
        specialityRepository.save(speciality);
    }

    public void deleteSpeciality(Long id){
        specialityRepository.deleteById(id);
    }

}
