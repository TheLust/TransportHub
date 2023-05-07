package com.practica.TransportHub.service;

import com.practica.TransportHub.model.RaceEntity;
import com.practica.TransportHub.model.dto.RaceDTO;
import com.practica.TransportHub.repository.DestinationRepository;
import com.practica.TransportHub.repository.RaceRepository;
import com.practica.TransportHub.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RaceService {
    
    private final RaceRepository raceRepository;
    private final DestinationRepository destinationRepository;
    private final RouteRepository routeRepository;
    
    public RaceEntity getRaceByName(String name) {
        return raceRepository.findByName(name);
    }
    
    public List<RaceEntity> getAllRaces() {
        return raceRepository.findAll();
    }
    
    public void addRace(RaceDTO raceDTO) {
        RaceEntity raceEntity = new RaceEntity();
        raceEntity.setName(raceDTO.getName());
        raceEntity.setDestination(destinationRepository.findByName(raceDTO.getDestination()));
        raceEntity.setRoute(routeRepository.findByName(raceDTO.getRoute()));
        raceEntity.setBus(raceDTO.getBus());
        raceEntity.setRegistrationNumber(raceDTO.getRegistrationNumber());
        raceEntity.setNumberOfSeats(raceDTO.getNumberOfSeats());
        raceEntity.setPrice(raceDTO.getPrice());
        raceRepository.save(raceEntity);
    }
    
    public Optional<RaceEntity> findRace(long id) {
        return raceRepository.findById(id);
    }
    
    public void updateRace(RaceDTO raceDTO) {
        RaceEntity raceEntity = new RaceEntity();
        raceEntity.setId(raceDTO.getId());
        raceEntity.setName(raceDTO.getName());
        raceEntity.setDestination(destinationRepository.findByName(raceDTO.getDestination()));
        raceEntity.setRoute(routeRepository.findByName(raceDTO.getRoute()));
        raceEntity.setBus(raceDTO.getBus());
        raceEntity.setRegistrationNumber(raceDTO.getRegistrationNumber());
        raceEntity.setNumberOfSeats(raceDTO.getNumberOfSeats());
        raceEntity.setPrice(raceDTO.getPrice());
        raceRepository.save(raceEntity);
    }
    
    public void removeRace(RaceEntity raceEntity) {
        raceRepository.delete(raceEntity);
    }
    
}
