package com.practica.TransportHub.repository;

import com.practica.TransportHub.model.DestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {
    DestinationEntity findByName(String name);
}
