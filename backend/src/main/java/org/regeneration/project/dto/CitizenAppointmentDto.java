package org.regeneration.project.dto;




import java.util.Date;


public class CitizenAppointmentDto {

    private Date appointmentDate;
    private String description;
    private String notes;

    public CitizenAppointmentDto(Date appointmentDate, String description, String notes){
        this.appointmentDate = appointmentDate;
        this.description = description;
        this.notes = notes;
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
}
