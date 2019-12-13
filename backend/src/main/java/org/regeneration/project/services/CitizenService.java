package org.regeneration.project.services;

import org.regeneration.project.models.Citizen;
import org.regeneration.project.models.User;
import org.regeneration.project.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    private CitizenRepository citizenRepository;

    public CitizenService(@Autowired CitizenRepository citizenRepository){this.citizenRepository = citizenRepository;}

    //GET ALL Citizens
    public List<Citizen> getAllCitizens(){
        return citizenRepository.findAll();
    }

    //POST NEW USER
    public Citizen postNewCitizen(Citizen newCitizen){
        return citizenRepository.save(newCitizen);
    }

    //GET ONE USER
    public Optional<Citizen> getOneCitizen(Long id){
        return citizenRepository.findById(id);
    }

    //UPDATE ONE USER IF EXISTS OR INSERT INTO DB
//    public Citizen updateCitizen(Citizen newCitizen, Long id){
//        return citizenRepository.findById(id)
//                .map(citizen -> {
//
//                })
//                .orElseGet(() -> {
//
//                });
//    }

    //DELETE ONE USER
    public void deleteCitizen(Long id){
        citizenRepository.deleteById(id);
    }
}
