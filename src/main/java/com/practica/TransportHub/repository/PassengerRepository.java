package com.practica.TransportHub.repository;

import com.practica.TransportHub.model.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
    List<PassengerEntity> findByPhoneNumber(String phoneNumber);

    List<PassengerEntity> findByEmail(String email);
}
