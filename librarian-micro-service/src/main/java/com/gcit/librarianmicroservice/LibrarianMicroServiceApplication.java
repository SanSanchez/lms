package com.gcit.librarianmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LibrarianMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarianMicroServiceApplication.class, args);
    }
}
