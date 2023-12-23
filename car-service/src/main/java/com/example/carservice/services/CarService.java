package com.example.carservice.services;

import com.example.carservice.entities.Car;
import com.example.carservice.entities.Client;
import com.example.carservice.models.CarResponse;
import com.example.carservice.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
    private final RestTemplate restTemplate;
    private final String url = "http://gateway-service:8080/CLIENT-SERVICE";

    public List<CarResponse> findAll() {
        List<Car> cars = repository.findAll();

        ResponseEntity<Client[]> response = restTemplate.getForEntity(url + "/api/clients", Client[].class);

        Client[] clients = response.getBody();

        return cars.stream().map((Car car) -> mapToCarResponse(car, clients)).toList();
    }

    private CarResponse mapToCarResponse(Car car, Client[] clients) {
        Client client = Arrays.stream(clients).
                filter(c -> c.getId().equals(car.getClientId()))
                .findFirst().orElse(null);

        return CarResponse
                .builder()
                .id(car.getId())
                .brand(car.getBrand())
                .matricule(car.getMatricule())
                .client(client)
                .model(car.getModel())
                .build();
    }
}
