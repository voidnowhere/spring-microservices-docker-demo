package com.example.carservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String matricule;
    private Long clientId;

    public Car(String brand, String model, String matricule, Long clientId) {
        this.brand = brand;
        this.model = model;
        this.matricule = matricule;
        this.clientId = clientId;
    }
}
