package org.regeneration.project.dto;




import com.fasterxml.jackson.annotation.JsonIgnore;
import org.regeneration.project.models.Doctor;
import org.regeneration.project.models.Speciality;

import java.util.Date;


public class CitizenAppointmentDto {

    private Date appointmentDate;
    private String description;
    private String notes;
    private Doctor doctor;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorSpeciality;


    public CitizenAppointmentDto(Date appointmentDate, String description, String notes, Doctor doctor){
        this.appointmentDate = appointmentDate;
        this.description = description;
        this.notes = notes;
        this.doctorFirstName = doctor.getUser().getFirstName();
        this.doctorLastName = doctor.getUser().getLastName();
        this.doctorSpeciality = doctor.getSpeciality().getName();
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

    @JsonIgnore
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

}
