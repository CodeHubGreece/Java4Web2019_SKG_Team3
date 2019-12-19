package org.regeneration.project.repositories;

import org.regeneration.project.dto.CitizenAppointmentDto;
import org.regeneration.project.dto.DoctorAppointmentDto;
import org.regeneration.project.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{



}
