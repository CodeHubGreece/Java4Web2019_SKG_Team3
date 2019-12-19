package org.regeneration.project.repositories;

import org.regeneration.project.models.Appointment;
import org.regeneration.project.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

    List<Speciality> findByNameContains(String keyword);
}
