package com.practica.TransportHub.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RaceDTO {
    private long id = 0;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Destination is mandatory")
    private String destination;
    @NotBlank(message = "Route is mandatory")
    private String route;
    @NotBlank(message = "Bus type is mandatory")
    private String bus;
    @NotBlank(message = "Registration number is mandatory")
    private String registrationNumber;
    @NotNull(message = "Number of seats is mandatory")
    private int numberOfSeats;
    @NotNull(message = "Price is mandatory")
    private double price;
}
