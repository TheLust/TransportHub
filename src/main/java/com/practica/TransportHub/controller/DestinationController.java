package com.practica.TransportHub.controller;

import com.practica.TransportHub.model.DestinationEntity;
import com.practica.TransportHub.service.DestinationService;
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
@RequestMapping("/destinations")
public class DestinationController {
    
    private final DestinationService destinationService;
    
    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }
    
    @GetMapping("signup")
    public String showSignUpForm(DestinationEntity destinationEntity) {
        return "add-destination";
    }
    
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "destinations";
    }
    
    @PostMapping("add")
    public String addDestination(@Valid DestinationEntity destinationEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-destination";
        }
        destinationService.addDestination(destinationEntity);
        return "redirect:list";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        DestinationEntity destinationEntity = getDestination(id);
        model.addAttribute("destination", destinationEntity);
        return "update-destination";
    }
    
    
    @PostMapping("update/{id}")
    public String updateDestination(@PathVariable("id") long id, @Valid DestinationEntity destinationEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            destinationEntity.setId(id);
            return "update-destination";
        }
        destinationService.updateDestination(destinationEntity);
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "destinations";
    }
    
    @GetMapping("delete/{id}")
    public String deleteDestination(@PathVariable("id") long id, Model model) {
        DestinationEntity destinationEntity = getDestination(id);
        destinationService.removeDestination(destinationEntity);
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "destinations";
    }
    
    private DestinationEntity getDestination(@PathVariable("id") long id) {
        DestinationEntity destinationEntity;
        if (destinationService.findDestination(id).isPresent()) {
            destinationEntity = destinationService.findDestination(id).get();
        } else {
            throw new IllegalArgumentException("Invalid Destination ID: " + id);
        }
        return destinationEntity;
    }
    
}
