package com.gcit.administratormicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdministratorMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdministratorMicroServiceApplication.class, args);
    }
}