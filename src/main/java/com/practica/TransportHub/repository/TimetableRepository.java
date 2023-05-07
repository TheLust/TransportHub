package com.practica.TransportHub.repository;

import com.practica.TransportHub.model.TimetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<TimetableEntity, Long> {
    //TimetableEntity findByName(String name);
}
