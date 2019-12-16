package org.regeneration.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class UserCitizenDto implements Dto{
    private Long citizenId;
    private String userFirstName;
    private String userLastName;
    private String citizenSSN;
    private String userType;
    private List<CitizenAppointmentDto> citizenAppointmentDto;

    public UserCitizenDto(String userFirstName, String userLastName, String citizenSSN, Long citizenId){
        this.citizenId = citizenId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.citizenSSN = citizenSSN;
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

    public String getCitizenSSN() {
        return citizenSSN;
    }

    public void setCitizenSSN(String citizenSSN) {
        this.citizenSSN = citizenSSN;
    }

    @JsonIgnore
    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public List<CitizenAppointmentDto> getCitizenAppointmentDto() {
        return citizenAppointmentDto;
    }

    public void setCitizenAppointmentDto(List<CitizenAppointmentDto> citizenAppointmentDto) {
        this.citizenAppointmentDto = citizenAppointmentDto;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
