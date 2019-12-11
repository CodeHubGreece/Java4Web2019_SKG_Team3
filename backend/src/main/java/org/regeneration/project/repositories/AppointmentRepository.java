package org.regeneration.project.repositories;

import org.regeneration.project.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctor_Id(Long doctorid);
    Optional<Appointment> findByIdAndDoctor_Id(Long id, Long doctorid);

    List<Appointment> findByCitizen_Id(Long citizenid);
    Optional<Appointment> findByIdAndAndCitizen_Id(Long id, Long citizen);
}
