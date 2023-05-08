package com.practica.TransportHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table
@Setter
@Getter
public class RouteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name", unique = true)
    private String name;

    public RouteEntity() {
    }

    public RouteEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
