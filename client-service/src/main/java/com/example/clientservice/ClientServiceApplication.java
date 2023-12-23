package com.example.clientservice;

import com.example.clientservice.entities.Client;
import com.example.clientservice.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiseBase(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client("Rabab SELIMANI", 22));
            clientRepository.save(new Client("Amal RAMI", 22));
            clientRepository.save(new Client("Samir SAFI", 23));
        };
    }
}
