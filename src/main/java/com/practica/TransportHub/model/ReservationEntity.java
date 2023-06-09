package com.practica.TransportHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table
@Entity
@Getter
@Setter
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @NotNull(message = "Timetable is mandatory")
    private TimetableEntity timetable;

    @ManyToOne
    @NotNull(message = "Passenger is mandatory")
    private PassengerEntity passenger;

    @NotNull(message = "Date is mandatory")
    private LocalDate date;

    @NotNull(message = "Seat is mandatory")
    @Min(value = 1, message = "The min seat number is")
    private int seat;

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
