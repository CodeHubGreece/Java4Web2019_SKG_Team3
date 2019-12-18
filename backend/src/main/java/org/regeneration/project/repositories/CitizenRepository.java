package org.regeneration.project.repositories;

import org.regeneration.project.dto.CitizenAppointmentDto;
import org.regeneration.project.dto.UserCitizenDto;
import org.regeneration.project.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {



    @Query("SELECT new org.regeneration.project.dto.CitizenAppointmentDto(a.appointmentDate, a.description, a.notes, a.doctor, a.id) "
            + "FROM Citizen c LEFT JOIN c.appointments a WHERE c.id = :id")
    List<CitizenAppointmentDto> fetchEmpDeptDataLeftJoin(@Param("id") Long id);

    Long findCitizenIdByUserId(Long id);

    Citizen findCitizenIdById(Long citizenId);
}
