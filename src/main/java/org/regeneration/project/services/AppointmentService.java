package org.regeneration.project.services;

import org.regeneration.project.models.Appointment;
import org.regeneration.project.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments(){
        List<Appointment> appointments = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    public Optional<Appointment> getAppointment(Long id){
        return appointmentRepository.findById(id);
    }

    public void addAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
    }

    public void updateAppointment(Long id, Appointment appointment){
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

}
