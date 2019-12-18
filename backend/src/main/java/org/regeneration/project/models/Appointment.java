package org.regeneration.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="appointments")
public class Appointment implements Serializable {
    private Long id;
    private Date appointmentDate;
    private Citizen citizen;
    private Doctor doctor;
    private String description;
    private String notes;

    public Appointment() {}

    public Appointment(Date appointmentDate, Citizen citizen, Doctor doctor, String description, String notes) {
        this.appointmentDate = appointmentDate;
        this.citizen = citizen;
        this.doctor = doctor;
        this.description = description;
        this.notes = notes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date")
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "citizen_id")
    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointmentDate=" + appointmentDate +
                ", citizen=" + citizen +
                ", doctor=" + doctor +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
