package com.practica.TransportHub.controller;

import com.practica.TransportHub.model.ReservationEntity;
import com.practica.TransportHub.service.ReservationService;
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
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("signup")
    public String showSignUpForm(ReservationEntity reservationEntity) {
        return "add-reservation";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

    @PostMapping("add")
    public String addReservation(@Valid ReservationEntity reservationEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-reservation";
        }
        reservationService.addReservation(reservationEntity);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ReservationEntity reservationEntity = getReservation(id);
        model.addAttribute("reservation", reservationEntity);
        return "update-reservation";
    }


    @PostMapping("update/{id}")
    public String updateReservation(@PathVariable("id") long id, @Valid ReservationEntity reservationEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            reservationEntity.setId(id);
            return "update-reservation";
        }
        reservationService.updateReservation(reservationEntity);
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

    @GetMapping("delete/{id}")
    public String deleteReservation(@PathVariable("id") long id, Model model) {
        ReservationEntity reservationEntity = getReservation(id);
        reservationService.removeReservation(reservationEntity);
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

    private ReservationEntity getReservation(@PathVariable("id") long id) {
        ReservationEntity reservationEntity;
        if (reservationService.findReservation(id).isPresent()) {
            reservationEntity = reservationService.findReservation(id).get();
        } else {
            throw new IllegalArgumentException("Invalid Reservation ID: " + id);
        }
        return reservationEntity;
    }
}
