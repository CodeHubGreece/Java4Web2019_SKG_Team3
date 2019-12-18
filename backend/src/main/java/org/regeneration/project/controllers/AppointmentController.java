package org.regeneration.project.controllers;

import org.regeneration.project.dto.NewAppointmentDto;
import org.regeneration.project.models.Appointment;
import org.regeneration.project.repositories.CitizenRepository;
import org.regeneration.project.repositories.DoctorRepository;
import org.regeneration.project.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;
    private CitizenRepository citizenRepository;
    private DoctorRepository doctorRepository;

    public AppointmentController(@Autowired AppointmentService appointmentService, @Autowired CitizenRepository citizenRepository,
                                 @Autowired DoctorRepository doctorRepository){
        this.appointmentService = appointmentService;
        this.citizenRepository = citizenRepository;
        this.doctorRepository = doctorRepository;
    }


    //Single Item
    @GetMapping("/{id}")
    public Optional<Appointment> getOneAppointment(@PathVariable Long id){ return appointmentService.getOneAppointment(id);}

    @GetMapping("/search")
    public List<Appointment> searchAppointments(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") Date startDate, @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date endDate){
        return appointmentService.searchAppointment(startDate, endDate);
    }

    @PostMapping("")
    public Appointment getNewAppointment(@RequestBody NewAppointmentDto newAppointment){
        newAppointment.setCitizen(citizenRepository.findCitizenIdById(newAppointment.getCitizendId()));
        newAppointment.setDoctor(doctorRepository.findDoctorIdById(newAppointment.getDoctorId()));
        Appointment appointment = new Appointment(newAppointment.getAppointment(),
                newAppointment.getCitizen(), newAppointment.getDoctor(),
                newAppointment.getDescription(), newAppointment.getNotes());
        return appointmentService.postNewAppointment(appointment);
    }


    @PutMapping("/{id}")
    public Optional<Appointment> updateAppointment(@RequestBody Appointment newAppointment, @RequestParam Long id){
        return appointmentService.updateAppointment(newAppointment, id);
    }


    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
    }
}
