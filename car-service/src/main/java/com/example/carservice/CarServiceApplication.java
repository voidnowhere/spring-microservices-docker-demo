package com.example.carservice;

import com.example.carservice.entities.Car;
import com.example.carservice.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);

        return restTemplate;
    }

    @Bean
    CommandLineRunner initialiseBase(CarRepository carRepository) {
        return args -> {
            carRepository.save(new Car("Honda", "Civic", "FF", 1L));
        };
    }
}
