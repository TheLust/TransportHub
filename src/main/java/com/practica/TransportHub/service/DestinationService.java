package com.practica.TransportHub.service;

import com.practica.TransportHub.model.DestinationEntity;
import com.practica.TransportHub.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DestinationService {
    
    private final DestinationRepository destinationRepository;
    
    public DestinationEntity getDestinationByName(String name) {
        return destinationRepository.findByName(name);
    }
    
    public List<DestinationEntity> getAllDestinations() {
        return destinationRepository.findAll();
    }
    
    public void addDestination(DestinationEntity destinationEntity) {
        destinationRepository.save(destinationEntity);
    }
    
    public Optional<DestinationEntity> findDestination(long id) {
        return destinationRepository.findById(id);
    }
    
    public void updateDestination(DestinationEntity destinationEntity) {
        destinationRepository.save(destinationEntity);
    }
    
    public void removeDestination(DestinationEntity destinationEntity) {
        destinationRepository.delete(destinationEntity);
    }
    
}
