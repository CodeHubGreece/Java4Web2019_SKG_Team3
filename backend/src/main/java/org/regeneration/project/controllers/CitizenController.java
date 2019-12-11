package org.regeneration.project.controllers;

import org.regeneration.project.models.Citizen;
import org.regeneration.project.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @GetMapping("/citizens")
    public List<Citizen> getAllCitizens(){
        return citizenService.getAllCitizens();
    }

    @GetMapping("/citizens/{id}")
    public Optional<Citizen> getCitizen(@PathVariable Long id){
        return citizenService.getCitizen(id);
    }

    @PostMapping("/citizens")
    public void addCitizen(@RequestBody Citizen citizen){
        citizenService.addCitizen(citizen);
    }

    @PutMapping("/citizens{id}")
    public void updateCitizen(@RequestBody Long id, @RequestBody Citizen citizen){
        citizenService.updateCitizen(id, citizen);
    }

    @DeleteMapping ("/citizens{id}")
    public void deleteCitizen(@RequestBody Long id){
        citizenService.deleteCitizen(id);
    }

}
