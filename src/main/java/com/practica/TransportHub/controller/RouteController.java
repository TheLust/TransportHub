package com.practica.TransportHub.controller;

import com.practica.TransportHub.model.RouteEntity;
import com.practica.TransportHub.service.RouteService;
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
@RequestMapping("/routes")
public class RouteController {
    
    private final RouteService routeService;
    
    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    
    @GetMapping("signup")
    public String showSignUpForm(RouteEntity routeEntity) {
        return "add-route";
    }
    
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("routes", routeService.getAllRoutes());
        return "routes";
    }
    
    @PostMapping("add")
    public String addRoute(@Valid RouteEntity routeEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-route";
        }
        routeService.addRoute(routeEntity);
        return "redirect:list";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        RouteEntity routeEntity = getRoute(id);
        model.addAttribute("route", routeEntity);
        return "update-route";
    }
    
    
    @PostMapping("update/{id}")
    public String updateRoute(@PathVariable("id") long id, @Valid RouteEntity routeEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            routeEntity.setId(id);
            return "update-route";
        }
        routeService.updateRoute(routeEntity);
        model.addAttribute("routes", routeService.getAllRoutes());
        return "routes";
    }
    
    @GetMapping("delete/{id}")
    public String deleteRoute(@PathVariable("id") long id, Model model) {
        RouteEntity routeEntity = getRoute(id);
        routeService.removeRoute(routeEntity);
        model.addAttribute("routes", routeService.getAllRoutes());
        return "routes";
    }
    
    private RouteEntity getRoute(@PathVariable("id") long id) {
        RouteEntity routeEntity;
        if (routeService.findRoute(id).isPresent()) {
            routeEntity = routeService.findRoute(id).get();
        } else {
            throw new IllegalArgumentException("Invalid Route ID: " + id);
        }
        return routeEntity;
    }
    
}
