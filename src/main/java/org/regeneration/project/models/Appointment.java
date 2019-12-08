package org.regeneration.project.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="appointments")
public class Appointment implements Serializable {
    private Long id;
    private Date appointmentDate;
    private Citizen citizen;
    private Doctor doctor;
    private String description;
    private String notes;

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

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

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
}
