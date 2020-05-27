package org.regeneration.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.regeneration.project.models.Citizen;
import org.regeneration.project.models.Doctor;

import java.util.Date;

public class NewAppointmentDto {

    private Date appointmentDate;
    private String description;
    private String notes;
    private Long citizenId;
    private Long doctorId;
    private Citizen citizen;
    private Doctor doctor;

    public NewAppointmentDto(Date appointmentDate, String description, String notes, Long citizenId, Long doctorId) {
        this.appointmentDate = appointmentDate;
        this.description = description;
        this.notes = notes;
        this.citizenId = citizenId;
        this.doctorId = doctorId;
    }

    public Date getAppointment() {
        return appointmentDate;
    }

    public void setAppointment(Date appointment) {
        this.appointmentDate = appointment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getCitizendId() {
        return citizenId;
    }


    public void setCitizendId(Long citizendId) {
        this.citizenId = citizendId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @JsonIgnore
    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
