package org.regeneration.project.services;

import org.regeneration.project.dto.CitizenAppointmentDto;
import org.regeneration.project.dto.Dto;
import org.regeneration.project.dto.UserCitizenDto;
import org.regeneration.project.models.Citizen;
import org.regeneration.project.repositories.CitizenRepository;
import org.regeneration.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    private CitizenRepository citizenRepository;
    private UserRepository userRepository;

    public CitizenService(@Autowired CitizenRepository citizenRepository, @Autowired UserRepository userRepository){
        this.citizenRepository = citizenRepository;
        this.userRepository = userRepository;
    }

    //GET ALL Citizens
    public List<Citizen> getAllCitizens(){
        return citizenRepository.findAll();
    }

    //POST NEW USER
    public Citizen postNewCitizen(Citizen newCitizen){
        return citizenRepository.save(newCitizen);
    }

    //GET ONE USER
    public List<CitizenAppointmentDto> getOneCitizen(Long id){

            return this.fetchEmpDeptDataInnerJoin(id);
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

    public List<CitizenAppointmentDto> fetchEmpDeptDataInnerJoin(Long id){
        return citizenRepository.fetchEmpDeptDataLeftJoin(id);
    }

    public Long findCitizenIdByUserId(Long id){
        return citizenRepository.findCitizenIdByUserId(id);
    }

    public Dto getCitizenById(Long id) {
        Optional<Citizen> citizen = citizenRepository.findById(id);
        org.regeneration.project.models.User user = userRepository.findByCitizenId(id);

        UserCitizenDto userCitizenDto = new UserCitizenDto(user.getFirstName(), user.getLastName(), user.getUsername(), citizen.get().getSsn(), user.getEmail(), citizen.get().getMobileNumber(), citizen.get().getId());
        return userCitizenDto;
    }
}
