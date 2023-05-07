package com.practica.TransportHub.service;

import com.practica.TransportHub.model.PassengerEntity;
import com.practica.TransportHub.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public List<PassengerEntity> getPassengerByPhoneNumber(String phoneNumber) {
        return passengerRepository.findByPhoneNumber(phoneNumber);
    }

    public List<PassengerEntity> getPassengerByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }

    public List<PassengerEntity> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public void addPassenger(PassengerEntity passengerEntity) {
        passengerRepository.save(passengerEntity);
    }

    public Optional<PassengerEntity> findPassenger(long id) {
        return passengerRepository.findById(id);
    }

    public void updatePassenger(PassengerEntity passengerEntity) {
        passengerRepository.save(passengerEntity);
    }

    public void removePassenger(PassengerEntity passengerEntity) {
        passengerRepository.delete(passengerEntity);
    }
}
