package org.regeneration.project.repositories;

import org.regeneration.project.dto.UserCitizenDto;
import org.regeneration.project.dto.UserDoctorDto;
import org.regeneration.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT new org.regeneration.project.dto.UserCitizenDto(u.firstName, u.lastName, c.ssn, c.id) "
            + "FROM User u LEFT JOIN u.citizen c WHERE u.username = :username")
    UserCitizenDto fetchUserCitizenLeftJoin(@Param("username") String username);

    @Query("SELECT new org.regeneration.project.dto.UserDoctorDto(u.firstName, u.lastName, d.id) "
            + "FROM User u LEFT JOIN u.doctor d WHERE u.username = :username")
    UserDoctorDto fetchUserDoctorLeftJoin(@Param("username") String username);


}
