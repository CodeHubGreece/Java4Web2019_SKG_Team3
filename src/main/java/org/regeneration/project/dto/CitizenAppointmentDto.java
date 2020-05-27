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
    private Long doctorId;
    private Long appointmentId;
    private Long specialityId;


    public CitizenAppointmentDto(Date appointmentDate, String description, String notes, Doctor doctor, Long appointmentId){
        this.appointmentDate = appointmentDate;
        this.description = description;
        this.notes = notes;
        this.doctorFirstName = doctor.getUser().getFirstName();
        this.doctorLastName = doctor.getUser().getLastName();
        this.doctorSpeciality = doctor.getSpeciality().getName();
        this.doctorId = doctor.getId();
        this.appointmentId = appointmentId;
        this.specialityId = doctor.getSpeciality().getId();
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

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }


}
