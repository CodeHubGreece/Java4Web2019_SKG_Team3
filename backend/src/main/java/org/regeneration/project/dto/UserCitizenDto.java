package org.regeneration.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class UserCitizenDto implements Dto{
    private Long citizenId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userUsername;
    private String userMobileNumber;
    private String citizenSSN;
    private String userType;
    private List<CitizenAppointmentDto> citizenAppointmentDto;

    public UserCitizenDto(String userFirstName, String userLastName, String userUsername, String citizenSSN, String userEmail, String userMobileNumber, Long citizenId){
        this.citizenId = citizenId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userUsername = userUsername;
        this.citizenSSN = citizenSSN;
        this.userEmail = userEmail;
        this.userMobileNumber = userMobileNumber;
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

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
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
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
