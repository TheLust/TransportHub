package com.practica.TransportHub.controller;

import com.practica.TransportHub.model.RaceEntity;
import com.practica.TransportHub.service.RaceService;
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
@RequestMapping("/races")
public class RaceController {
    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("signup")
    public String showSignUpForm(RaceEntity raceEntity) {
        return "add-race";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("races", raceService.getAllRaces());
        return "races";
    }

    @PostMapping("add")
    public String addRace(@Valid RaceEntity raceEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-race";
        }
        raceService.addRace(raceEntity);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        RaceEntity raceEntity = getRace(id);
        model.addAttribute("race", raceEntity);
        return "update-race";
    }


    @PostMapping("update/{id}")
    public String updateRace(@PathVariable("id") long id, @Valid RaceEntity raceEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            raceEntity.setId(id);
            return "update-race";
        }
        raceService.updateRace(raceEntity);
        model.addAttribute("races", raceService.getAllRaces());
        return "races";
    }

    @GetMapping("delete/{id}")
    public String deleteRace(@PathVariable("id") long id, Model model) {
        RaceEntity raceEntity = getRace(id);
        raceService.removeRace(raceEntity);
        model.addAttribute("races", raceService.getAllRaces());
        return "races";
    }

    private RaceEntity getRace(@PathVariable("id") long id) {
        RaceEntity raceEntity;
        if (raceService.findRace(id).isPresent()) {
            raceEntity = raceService.findRace(id).get();
        } else {
            throw new IllegalArgumentException("Invalid Race ID: " + id);
        }
        return raceEntity;
    }
}
