package com.practica.TransportHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @Column(unique = true)
    @NotBlank(message = "Name is mandatory")
    private String name;
    @ManyToOne
    @NotNull(message = "Destination is mandatory")
    private DestinationEntity destination;
    @ManyToOne
    @NotNull(message = "Route is mandatory")
    private RouteEntity route;
    @NotBlank(message = "Bus is mandatory")
    private String bus;
    @NotBlank(message = "Registration number is mandatory")
    private String registrationNumber;
    @NotNull(message = "Number of seats is mandatory")
    private int numberOfSeats;

    @NotNull(message = "Price is mandatory")
    private double price;

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
