package com.practica.TransportHub.controller;

import com.practica.TransportHub.model.RaceEntity;
import com.practica.TransportHub.model.dto.RaceDTO;
import com.practica.TransportHub.service.DestinationService;
import com.practica.TransportHub.service.RaceService;
import com.practica.TransportHub.service.RouteService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class RaceController {
    
    private final RaceService raceService;
    
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
    public String addRace(@Valid RaceDTO raceDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-race";
        }
        raceService.addRace(raceDTO);
        return "redirect:list";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        RaceEntity raceEntity = getRace(id);
        RaceDTO raceDTO = new RaceDTO();
        raceDTO.setId(raceEntity.getId());
        raceDTO.setName(raceEntity.getName());
        raceDTO.setDestination(raceEntity.getDestination().getName());
        raceDTO.setRoute(raceEntity.getRoute().getName());
        raceDTO.setBus(raceEntity.getBus());
        raceDTO.setRegistrationNumber(raceEntity.getRegistrationNumber());
        raceDTO.setNumberOfSeats(raceEntity.getNumberOfSeats());
        raceDTO.setPrice(raceEntity.getPrice());
        model.addAttribute("race", raceDTO);
        return "update-race";
    }
    
    
    @PostMapping("update/{id}")
    public String updateRace(@PathVariable("id") long id, @Valid RaceDTO raceDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            raceDTO.setId(id);
            return "update-race";
        }
        raceService.updateRace(raceDTO);
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
