package org.regeneration.project.services;

import org.regeneration.project.dto.*;
import org.regeneration.project.models.Citizen;
import org.regeneration.project.models.User;
import org.regeneration.project.models.UserType;
import org.regeneration.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private  UserRepository userRepository;
    private CitizenService citizenService;
    private DoctorService doctorService;

    public UserService(@Autowired UserRepository userRepository, @Autowired CitizenService citizenService, @Autowired DoctorService doctorService){
        this.userRepository = userRepository;
        this.doctorService = doctorService;
        this.citizenService = citizenService;
    }
    //GET ALL USERS
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public Dto getLoggedInUser(Principal loggedInUser) {
//        return userRepository.findByUsername(loggedInUser.getName());
        User authUser = userRepository.findByUsername(loggedInUser.getName());
        UserType userType = authUser.getUserType();

        if(userType == UserType.CITIZEN){
            UserCitizenDto userCitizenDto =  this.fetchUserCitizenInnerJoin(loggedInUser.getName());
            List<CitizenAppointmentDto> appointments = this.citizenService.fetchEmpDeptDataInnerJoin(userCitizenDto.getCitizenId());
            userCitizenDto.setCitizenAppointmentDto(appointments);
            return userCitizenDto;
        }else{
            UserDoctorDto userDoctorDto = this.fetchUserDoctorInnerJoin(loggedInUser.getName());
            List<DoctorAppointmentDto> appointments = this.doctorService.fetchEmpDeptDataInnerJoin(userDoctorDto.getDoctorId());
            DoctorSpecialityDto specialityDto = this.doctorService.fetchDoctorSpecialityInnerJoin(userDoctorDto.getDoctorId());
            userDoctorDto.setDoctorSpecialityDto(specialityDto);
            userDoctorDto.setDoctorAppointmentDto(appointments);
            return userDoctorDto;
        }
    }

    //POST NEW USER
    public User postNewUser(User newUser){
        return userRepository.save(newUser);
    }

    //GET ONE USER
    public Optional<User> getOneUser(Long id){
        return userRepository.findById(id);
    }

    //UPDATE ONE USER IF EXISTS OR INSERT INTO DB
    public void updateUser(User newUser, Long id){
//        return userRepository.findById(id)
////                .map(user -> {
////                    user.setFirstName(newUser.setFirstName());
////                    user.setLastName((newUser.setLastName()));
////                    user.setUsername((newUser.getUsername()));
////                    user.setPassword(newUser.getPassword());
////                    user.setEmail(newUser.getEmail());
////                    return userRepository.save(user);
////                })
////                .orElseGet(() -> {
////                    newUser.setId(id);
////                    return  userRepository.save(newUser);
////                });
    }

    //DELETE ONE USER
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public UserCitizenDto fetchUserCitizenInnerJoin(String username) {
        return userRepository.fetchUserCitizenLeftJoin(username);
    }

    public UserDoctorDto fetchUserDoctorInnerJoin(String username) {
        return userRepository.fetchUserDoctorLeftJoin(username);
    }
}
