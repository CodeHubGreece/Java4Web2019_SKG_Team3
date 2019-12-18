package org.regeneration.project.services;


import org.regeneration.project.models.Appointment;
import org.regeneration.project.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(@Autowired AppointmentRepository appointmentRepository){this.appointmentRepository = appointmentRepository;}

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

    //UPDATE ONE USER IF EXISTS OR INSERT INTO DB
//    public Doctor updateDoctor(Doctor newDoctor, Long id){
//        return doctorRepository.findById(id)
//                .map(doctor-> {
//
//                })
//                .orElseGet(() -> {
//
//                });
//    }

    //DELETE ONE USER
    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> searchAppointment(Date startDate, Date endDate) {
        return appointmentRepository.findByAppointmentDateBetween(startDate, endDate);
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
