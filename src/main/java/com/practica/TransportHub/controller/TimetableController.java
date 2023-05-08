package com.practica.TransportHub.controller;

import com.practica.TransportHub.model.TimetableEntity;
import com.practica.TransportHub.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/timetables")
public class TimetableController {
    private final TimetableService timetableService;

    @Autowired
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

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
    public String addTimetable(@Valid TimetableEntity timetableEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-timetable";
        }
        timetableService.addTimetable(timetableEntity);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TimetableEntity timetableEntity = getTimetable(id);
        model.addAttribute("timetable", timetableEntity);
        return "update-timetable";
    }


    @PostMapping("update/{id}")
    public String updateTimetable(@PathVariable("id") long id, @Valid TimetableEntity timetableEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            timetableEntity.setId(id);
            return "update-timetable";
        }
        timetableService.updateTimetable(timetableEntity);
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
