package com.practica.TransportHub.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TimetableDTO {
    private long id = 0;
    @NotBlank(message = "Race is mandatory")
    private String race;

    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Invalid time format. Must be in HH:mm format.")
    @NotNull(message = "Time is mandatory")
    private String time;

    @NotNull(message = "Platform is mandatory")
    @Min(value = 1, message = "Platform min number is 1")
    @Max(value = 100, message = "Platform max number is 100")
    private int platform;
}
