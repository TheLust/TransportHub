package com.practica.TransportHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @NotNull
    private DestinationEntity destination;
    @ManyToOne
    @NotNull
    private RouteEntity route;
    @Column(nullable = false)
    private String bus;
    @Column(nullable = false)
    private String registrationNumber;
    @Column(nullable = false)
    private int numberOfSeats;

    @Column(nullable = false)
    private double price;
}
