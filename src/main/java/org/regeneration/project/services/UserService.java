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
//    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }


    public Dto getLoggedInUser(Principal loggedInUser) {
//        return userRepository.findByUsername(loggedInUser.getName());
        User authUser = userRepository.findByUsername(loggedInUser.getName());
        UserType userType = authUser.getUserType();

        if(userType == UserType.CITIZEN){
            UserCitizenDto userCitizenDto =  this.fetchUserCitizenInnerJoin(loggedInUser.getName());
            List<CitizenAppointmentDto> appointments = this.citizenService.fetchEmpDeptDataInnerJoin(userCitizenDto.getCitizenId());
            userCitizenDto.setCitizenAppointmentDto(appointments);
            userCitizenDto.setUserType(UserType.CITIZEN.toString());
            return userCitizenDto;
        }else{
            UserDoctorDto userDoctorDto = this.fetchUserDoctorInnerJoin(loggedInUser.getName());
            List<DoctorAppointmentDto> appointments = this.doctorService.fetchEmpDeptDataInnerJoin(userDoctorDto.getDoctorId());
            DoctorSpecialityDto specialityDto = this.doctorService.fetchDoctorSpecialityInnerJoin(userDoctorDto.getDoctorId());
            userDoctorDto.setDoctorSpecialityDto(specialityDto);
            userDoctorDto.setDoctorAppointmentDto(appointments);
            userDoctorDto.setUserType(UserType.DOCTOR.toString());
            return userDoctorDto;
        }
    }



    public UserCitizenDto fetchUserCitizenInnerJoin(String username) {
        return userRepository.fetchUserCitizenLeftJoin(username);
    }

    public UserDoctorDto fetchUserDoctorInnerJoin(String username) {
        return userRepository.fetchUserDoctorLeftJoin(username);
    }


}
