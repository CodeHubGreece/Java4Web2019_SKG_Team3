package org.regeneration.project.controllers;

import org.regeneration.project.dto.CitizenAppointmentDto;
import org.regeneration.project.dto.Dto;
import org.regeneration.project.models.Citizen;
import org.regeneration.project.models.User;
import org.regeneration.project.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    private CitizenService citizenService;

    public CitizenController(@Autowired CitizenService citizenService){
        this.citizenService = citizenService;
    }

    @GetMapping("")
    public List<CitizenAppointmentDto> getOneCitizen(@PathVariable Long id){
        return citizenService.getOneCitizen(id);
    }

    @GetMapping("/{id}")
    public Dto getCitizenById(@PathVariable Long id){
        return citizenService.getCitizenById(id);
    }

    @PostMapping("")
    public Citizen getNewCitizen(@RequestBody Citizen newCitizen){
        return citizenService.postNewCitizen(newCitizen);
    }


    @DeleteMapping("/{id}")
    public void deleteCitizen(@PathVariable Long id){
        citizenService.deleteCitizen(id);
    }
}
