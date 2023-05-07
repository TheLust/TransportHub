package com.practica.TransportHub.controller;

import com.practica.TransportHub.model.PassengerEntity;
import com.practica.TransportHub.service.PassengerService;
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
@RequestMapping("/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("signup")
    public String showSignUpForm(PassengerEntity passengerEntity) {
        return "add-passenger";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("passengers", passengerService.getAllPassengers());
        return "passengers";
    }

    @PostMapping("add")
    public String addPassenger(@Valid PassengerEntity passengerEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-passenger";
        }
        passengerService.addPassenger(passengerEntity);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        PassengerEntity passengerEntity = getPassenger(id);
        model.addAttribute("passenger", passengerEntity);
        return "update-passenger";
    }


    @PostMapping("update/{id}")
    public String updatePassenger(@PathVariable("id") long id, @Valid PassengerEntity passengerEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            passengerEntity.setId(id);
            return "update-passenger";
        }
        passengerService.updatePassenger(passengerEntity);
        model.addAttribute("passengers", passengerService.getAllPassengers());
        return "passengers";
    }

    @GetMapping("delete/{id}")
    public String deletePassenger(@PathVariable("id") long id, Model model) {
        PassengerEntity passengerEntity = getPassenger(id);
        passengerService.removePassenger(passengerEntity);
        model.addAttribute("passengers", passengerService.getAllPassengers());
        return "passengers";
    }

    private PassengerEntity getPassenger(@PathVariable("id") long id) {
        PassengerEntity passengerEntity;
        if (passengerService.findPassenger(id).isPresent()) {
            passengerEntity = passengerService.findPassenger(id).get();
        } else {
            throw new IllegalArgumentException("Invalid Passenger ID: " + id);
        }
        return passengerEntity;
    }
}
