package org.regeneration.project.repositories;

import org.regeneration.project.dto.CitizenAppointmentDto;
import org.regeneration.project.dto.DoctorAppointmentDto;
import org.regeneration.project.dto.DoctorSpecialityDto;
import org.regeneration.project.dto.UserDoctorDto;
import org.regeneration.project.models.Doctor;
import org.regeneration.project.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT new org.regeneration.project.dto.DoctorAppointmentDto(a.appointmentDate, a.description, a.notes) "
            + "FROM Doctor d LEFT JOIN d.appointments a WHERE d.id = :id")
    List<DoctorAppointmentDto> fetchEmpDeptDataLeftJoin(@Param("id") Long id);

    Long findDoctorIdByUserId(Long id);

    @Query("SELECT new org.regeneration.project.dto.DoctorSpecialityDto(s.name) "
            + "FROM Doctor d LEFT JOIN d.speciality s WHERE d.id = :id")
    DoctorSpecialityDto fetchDoctorSpecialityLeftJoin(@Param("id") Long id);

    @Query("SELECT new org.regeneration.project.dto.UserDoctorDto(u.firstName, u.lastName, d.id) "
            + "FROM User u LEFT JOIN u.doctor d WHERE d.speciality.id = :speciality_id")
    List<UserDoctorDto> fetchDoctorbySpecialityLeftJoin(@Param("speciality_id") Long speciality_id);


}
