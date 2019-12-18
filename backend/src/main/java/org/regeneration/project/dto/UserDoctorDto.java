package org.regeneration.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class UserDoctorDto implements Dto{

    private String userFirstName;
    private String userLastName;
    private Long doctorId;
    private DoctorSpecialityDto doctorSpecialityDto;
    private List<DoctorAppointmentDto> doctorAppointmentDto;

    public UserDoctorDto(String userFirstName, String userLastName, Long doctorId){
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.doctorId = doctorId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public DoctorSpecialityDto getDoctorSpecialityDto() {
        return doctorSpecialityDto;
    }

    public void setDoctorSpecialityDto(DoctorSpecialityDto doctorSpecialityDto) {
        this.doctorSpecialityDto = doctorSpecialityDto;
    }

    public List<DoctorAppointmentDto> getDoctorAppointmentDto() {
        return doctorAppointmentDto;
    }

    public void setDoctorAppointmentDto(List<DoctorAppointmentDto> doctorAppointmentDto) {
        this.doctorAppointmentDto = doctorAppointmentDto;
    }

    @JsonIgnore
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
