package org.regeneration.project.services;

import org.regeneration.project.models.Citizen;
import org.regeneration.project.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public List<Citizen> getAllCitizens(){
        List<Citizen> citizens = new ArrayList<>();
        citizenRepository.findAll().forEach(citizens::add);
        return citizens;
    }

    public Optional<Citizen> getCitizen(Long id){
        return citizenRepository.findById(id);
    }

    public void addCitizen(Citizen citizen){
        citizenRepository.save(citizen);
    }

    public void updateCitizen(Long id, Citizen citizen){
        citizenRepository.save(citizen);
    }

    public void deleteCitizen(Long id){
        citizenRepository.deleteById(id);
    }

}
