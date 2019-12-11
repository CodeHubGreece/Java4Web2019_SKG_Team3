package org.regeneration.project.controllers;

import org.regeneration.project.models.Appointment;
import org.regeneration.project.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/appointments/{id}")
    public Optional<Appointment> getAppointment(@PathVariable Long id){
        return appointmentService.getAppointment(id);
    }

    @PostMapping("/appointments")
    public void addAppointment(@RequestBody Appointment appointment){
        appointmentService.addAppointment(appointment);
    }

    @PutMapping("/appointments{id}")
    public void updateAppointment(@RequestBody Long id, @RequestBody Appointment appointment){
        appointmentService.updateAppointment(id, appointment);
    }

    @DeleteMapping ("/appointments{id}")
    public void deleteAppointment(@RequestBody Long id){
        appointmentService.deleteAppointment(id);
    }

}
