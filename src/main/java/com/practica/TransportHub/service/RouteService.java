package com.practica.TransportHub.service;

import com.practica.TransportHub.model.RouteEntity;
import com.practica.TransportHub.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {
    
    private final RouteRepository routeRepository;
    
    public RouteEntity getRouteByName(String name) {
        return routeRepository.findByName(name);
    }
    
    public List<RouteEntity> getAllRoutes() {
        return routeRepository.findAll();
    }
    
    public void addRoute(RouteEntity routeEntity) {
        routeRepository.save(routeEntity);
    }
    
    public Optional<RouteEntity> findRoute(long id) {
        return routeRepository.findById(id);
    }
    
    public void updateRoute(RouteEntity routeEntity) {
        routeRepository.save(routeEntity);
    }
    
    public void removeRoute(RouteEntity routeEntity) {
        routeRepository.delete(routeEntity);
    }
    
}
