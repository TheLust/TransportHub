package com.practica.TransportHub.service;

import com.practica.TransportHub.model.TimetableEntity;
import com.practica.TransportHub.repository.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimetableService {
    private final TimetableRepository timetableRepository;

    public List<TimetableEntity> getAllTimetables() {
        return timetableRepository.findAll();
    }

    public void addTimetable(TimetableEntity timetableEntity) {
        timetableRepository.save(timetableEntity);
    }

    public Optional<TimetableEntity> findTimetable(long id) {
        return timetableRepository.findById(id);
    }

    public void updateTimetable(TimetableEntity timetableEntity) {
        timetableRepository.save(timetableEntity);
    }

    public void removeTimetable(TimetableEntity timetableEntity) {
        timetableRepository.delete(timetableEntity);
    }
}
