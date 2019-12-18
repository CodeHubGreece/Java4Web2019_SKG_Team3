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

    public DoctorAppointmentDto(Date appointmentDate, String description, String notes, Citizen citizen){
        this.appointmentDate = appointmentDate;
        this.description = description;
        this.notes = notes;
        this.citizenFirstName = citizen.getUser().getFirstName();
        this.citizenLastName = citizen.getUser().getLastName();
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

}
