package org.regeneration.project.dto;

import org.regeneration.project.models.Citizen;
import org.springframework.stereotype.Component;

import java.util.Date;


public class DoctorAppointmentDto {

    private Date appointmentDate;
    private String description;
    private String notes;
    private Citizen citizen;
    private String citizenFirstName;
    private String citizenLastName;
    private Long citizenId;
    private Long appointmentId;

    public DoctorAppointmentDto(Date appointmentDate, String description, String notes, Citizen citizen, Long appointmentId){
        this.appointmentDate = appointmentDate;
        this.description = description;
        this.notes = notes;
        this.citizenFirstName = citizen.getUser().getFirstName();
        this.citizenLastName = citizen.getUser().getLastName();
        this.citizenId = citizen.getId();
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
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

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public String getCitizenFirstName() {
        return citizenFirstName;
    }

    public void setCitizenFirstName(String citizenFirstName) {
        this.citizenFirstName = citizenFirstName;
    }

    public String getCitizenLastName() {
        return citizenLastName;
    }

    public void setCitizenLastName(String citizenLastName) {
        this.citizenLastName = citizenLastName;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

}
