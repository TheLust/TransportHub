package com.practica.TransportHub.controller;

import com.practica.TransportHub.model.TimetableEntity;
import com.practica.TransportHub.model.dto.TimetableDTO;
import com.practica.TransportHub.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/timetables")
@RequiredArgsConstructor
public class TimetableController {
    
    private final TimetableService timetableService;
    
    @GetMapping("signup")
    public String showSignUpForm(TimetableEntity timetableEntity) {
        return "add-timetable";
    }
    
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("timetables", timetableService.getAllTimetables());
        return "timetables";
    }
    
    @PostMapping("add")
    public String addTimetable(@Valid TimetableDTO timetableDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-timetable";
        }
        timetableService.addTimetable(timetableDTO);
        return "redirect:list";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TimetableEntity timetableEntity = getTimetable(id);
        TimetableDTO timetableDTO = new TimetableDTO();
        timetableDTO.setId(timetableEntity.getId());
        timetableDTO.setRace(timetableEntity.getRace().getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        timetableDTO.setTime(timetableEntity.getTime().format(formatter));
        timetableDTO.setPlatform(timetableEntity.getPlatform());
        model.addAttribute("timetable", timetableDTO);
        return "update-timetable";
    }
    
    
    @PostMapping("update/{id}")
    public String updateTimetable(@PathVariable("id") long id, @Valid TimetableDTO timetableDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            timetableDTO.setId(id);
            return "update-timetable";
        }
        timetableService.updateTimetable(timetableDTO);
        model.addAttribute("timetables", timetableService.getAllTimetables());
        return "timetables";
    }
    
    @GetMapping("delete/{id}")
    public String deleteTimetable(@PathVariable("id") long id, Model model) {
        TimetableEntity timetableEntity = getTimetable(id);
        timetableService.removeTimetable(timetableEntity);
        model.addAttribute("timetables", timetableService.getAllTimetables());
        return "timetables";
    }
    
    private TimetableEntity getTimetable(@PathVariable("id") long id) {
        TimetableEntity timetableEntity;
        if (timetableService.findTimetable(id).isPresent()) {
            timetableEntity = timetableService.findTimetable(id).get();
        } else {
            throw new IllegalArgumentException("Invalid Timetable ID: " + id);
        }
        return timetableEntity;
    }
    
}
