package com.practica.TransportHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table
@Setter
@Getter
public class PassengerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Must be a well-formed email address")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Length(min = 9, max = 9, message = "Phone number must have 9 characters")
    @Digits(message = "Must be a well-formed phone number", integer = 9, fraction = 0)
    private String phoneNumber;
}
