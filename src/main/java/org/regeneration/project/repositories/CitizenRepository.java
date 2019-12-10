package org.regeneration.project.repositories;

import org.regeneration.project.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
}
