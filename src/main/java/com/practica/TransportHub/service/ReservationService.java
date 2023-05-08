package com.practica.TransportHub.service;

import com.practica.TransportHub.model.ReservationEntity;
import com.practica.TransportHub.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<ReservationEntity> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void addReservation(ReservationEntity reservationEntity) {
        reservationRepository.save(reservationEntity);
    }

    public Optional<ReservationEntity> findReservation(long id) {
        return reservationRepository.findById(id);
    }

    public void updateReservation(ReservationEntity reservationEntity) {
        reservationRepository.save(reservationEntity);
    }

    public void removeReservation(ReservationEntity reservationEntity) {
        reservationRepository.delete(reservationEntity);
    }
}
