package com.javaspring.company.external.repositories;

import com.javaspring.company.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Integer> {
}
