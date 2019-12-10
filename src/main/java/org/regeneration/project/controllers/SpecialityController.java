package org.regeneration.project.controllers;

import org.regeneration.project.models.Speciality;
import org.regeneration.project.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/specialities")
    public List<Speciality> getAllSpecialities(){
        return specialityService.getAllSpecialities();
    }

    @GetMapping("/specialities/{id}")
    public Optional<Speciality> getSpeciality(@PathVariable Long id){
        return specialityService.getSpeciality(id);
    }

    @PostMapping("/specialities")
    public void addSpeciality(@RequestBody Speciality speciality){
        specialityService.addSpeciality(speciality);
    }

    @PutMapping("/specialities{id}")
    public void updateSpeciality(@RequestBody Long id, @RequestBody Speciality speciality){
        specialityService.updateSpeciality(id, speciality);
    }

    @DeleteMapping ("/specialities{id}")
    public void deleteSpeciality(@RequestBody Long id){
        specialityService.deleteSpeciality(id);
    }
}
