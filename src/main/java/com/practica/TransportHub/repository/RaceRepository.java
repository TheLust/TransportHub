package com.practica.TransportHub.repository;

import com.practica.TransportHub.model.RaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<RaceEntity, Long> {
    RaceEntity findByName(String name);
}
