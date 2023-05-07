package com.practica.TransportHub.repository;

import com.practica.TransportHub.model.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    RouteEntity findByName(String name);
}
