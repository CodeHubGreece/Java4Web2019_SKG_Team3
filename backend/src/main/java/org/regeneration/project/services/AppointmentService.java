package org.regeneration.project.services;


import org.regeneration.project.dto.CitizenAppointmentDto;
import org.regeneration.project.dto.DoctorAppointmentDto;
import org.regeneration.project.dto.UserCitizenDto;
import org.regeneration.project.dto.UserDoctorDto;
import org.regeneration.project.models.Appointment;
import org.regeneration.project.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private UserService userService;
    private CitizenService citizenService;
    private DoctorService doctorService;

    public AppointmentService(@Autowired AppointmentRepository appointmentRepository, @Autowired UserService userService,
                              @Autowired CitizenService citizenService, @Autowired DoctorService doctorService){
        this.appointmentRepository = appointmentRepository;
        this.userService = userService;
        this.citizenService = citizenService;
        this.doctorService = doctorService;
    }

    //GET ALL Appointments
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    //POST NEW USER
    public Appointment postNewAppointment(Appointment newAppointment){ return appointmentRepository.save(newAppointment);}

    //GET ONE USER
    public Optional<Appointment> getOneAppointment(Long id){
        return appointmentRepository.findById(id);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //DELETE ONE USER
    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

    public List<CitizenAppointmentDto> searchCitizenAppointment(Principal loggedInUser, Date startDate, Date endDate, Long specialityId) {
        UserCitizenDto userCitizenDto = userService.fetchUserCitizenInnerJoin(loggedInUser.getName());
        List<CitizenAppointmentDto> appointments = citizenService.fetchEmpDeptDataInnerJoin(userCitizenDto.getCitizenId());
        userCitizenDto.setCitizenAppointmentDto(appointments);
        List<CitizenAppointmentDto> searchedAppointments = new ArrayList<>();

        for(CitizenAppointmentDto appointment : appointments){
            if((appointment.getAppointmentDate().before(endDate) || appointment.getAppointmentDate().after(startDate))
                    && (appointment.getSpecialityId() == specialityId)){
                searchedAppointments.add(appointment);
            }
        }

        return searchedAppointments;
    }

    public List<DoctorAppointmentDto> searchDoctorAppointment(Principal loggedInUser, Date startDate, Date endDate, String keyword){
        UserDoctorDto userDoctorDto = userService.fetchUserDoctorInnerJoin(loggedInUser.getName());
        List<DoctorAppointmentDto> appointments = doctorService.fetchEmpDeptDataInnerJoin(userDoctorDto.getDoctorId());
        userDoctorDto.setDoctorAppointmentDto(appointments);
        List<DoctorAppointmentDto> searchedAppointments = new ArrayList<>();

        for(DoctorAppointmentDto appointment: appointments){
            if((appointment.getAppointmentDate().before(endDate) || appointment.getAppointmentDate().after(startDate))
                    && appointment.getDescription().contains(keyword)){
                searchedAppointments.add(appointment);
            }
        }

        return  searchedAppointments;
    }


    public Optional<Appointment> updateAppointment(Appointment newAppointment, Long id) {
         return appointmentRepository.findById(id)
                .map(appointment -> {
                    appointment.setAppointmentDate(newAppointment.getAppointmentDate());
                    appointment.setDescription(newAppointment.getDescription());
                    appointment.setNotes(newAppointment.getNotes());
                    return appointmentRepository.save(appointment);
                });
    }

}
