package com.practica.TransportHub.service;

import com.practica.TransportHub.model.TimetableEntity;
import com.practica.TransportHub.model.dto.TimetableDTO;
import com.practica.TransportHub.repository.*;
import com.practica.TransportHub.repository.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimetableService {
    private final TimetableRepository timetableRepository;
    private final RaceRepository raceRepository;
    
//    public TimetableEntity getTimetableByName(String name) {
//        return timetableRepository.findByName(name);
//    }
    
    public List<TimetableEntity> getAllTimetables() {
        return timetableRepository.findAll();
    }
    
    public void addTimetable(TimetableDTO timetableDTO) {
        TimetableEntity timetableEntity = new TimetableEntity();
        timetableEntity.setRace(raceRepository.findByName(timetableDTO.getRace()));
        timetableEntity.setTime(LocalTime.parse(timetableDTO.getTime()));
        timetableEntity.setPlatform(timetableDTO.getPlatform());
        timetableRepository.save(timetableEntity);
    }
    
    public Optional<TimetableEntity> findTimetable(long id) {
        return timetableRepository.findById(id);
    }
    
    public void updateTimetable(TimetableDTO timetableDTO) {
        TimetableEntity timetableEntity = new TimetableEntity();
        timetableEntity.setId(timetableDTO.getId());
        timetableEntity.setRace(raceRepository.findByName(timetableDTO.getRace()));
        timetableEntity.setTime(LocalTime.parse(timetableDTO.getTime()));
        timetableEntity.setPlatform(timetableDTO.getPlatform());
        timetableRepository.save(timetableEntity);
    }
    
    public void removeTimetable(TimetableEntity timetableEntity) {
        timetableRepository.delete(timetableEntity);
    }
    
}
