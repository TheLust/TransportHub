package com.practica.TransportHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class DestinationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name", unique = true)
    private String name;

    public DestinationEntity() {
    }

    public DestinationEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
