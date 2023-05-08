package com.practica.TransportHub.service;

import com.practica.TransportHub.model.RaceEntity;
import com.practica.TransportHub.repository.RaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RaceService {
    private final RaceRepository raceRepository;

    public RaceEntity getRaceByName(String name) {
        return raceRepository.findByName(name);
    }

    public List<RaceEntity> getAllRaces() {
        return raceRepository.findAll();
    }

    public void addRace(RaceEntity raceEntity) {
        raceRepository.save(raceEntity);
    }

    public Optional<RaceEntity> findRace(long id) {
        return raceRepository.findById(id);
    }

    public void updateRace(RaceEntity raceEntity) {
        raceRepository.save(raceEntity);
    }

    public void removeRace(RaceEntity raceEntity) {
        raceRepository.delete(raceEntity);
    }
}
