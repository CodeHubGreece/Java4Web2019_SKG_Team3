package org.regeneration.project.dto;

import org.springframework.stereotype.Component;


public class DoctorSpecialityDto {

    private String specialityName;

    public DoctorSpecialityDto(String specialityName){
        this.specialityName = specialityName;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }
}
