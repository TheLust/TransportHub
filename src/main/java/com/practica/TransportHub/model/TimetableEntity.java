package com.practica.TransportHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;

@Entity
@Table
@Getter
@Setter
public class TimetableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @NotNull(message = "Race is mandatory")
    private RaceEntity race;

    @NotNull(message = "Time is mandatory")
    private LocalTime time;

    @NotNull(message = "Platform is mandatory")
    @Min(value = 1, message = "Platform min number is 1")
    @Max(value = 100, message = "Platform max number is 100")
    private int platform;
}
