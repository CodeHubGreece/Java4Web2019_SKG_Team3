package org.regeneration.project.services;


import org.regeneration.project.models.Speciality;
import org.regeneration.project.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityService {

    private SpecialityRepository specialityRepository;

    public SpecialityService(@Autowired SpecialityRepository specialityRepository){this.specialityRepository = specialityRepository;}

    public List<Speciality> getAllSpecialities(){
        return specialityRepository.findAll();
    }

    //POST NEW USER
    public Speciality postNewSpeciality(Speciality newSpeciality){ return specialityRepository.save(newSpeciality);}

    //GET ONE USER
    public Optional<Speciality> getOneSpeciality(Long id){
        return specialityRepository.findById(id);
    }



    //DELETE ONE USER
    public void deleteSpeciality(Long id){
        specialityRepository.deleteById(id);
    }
}
