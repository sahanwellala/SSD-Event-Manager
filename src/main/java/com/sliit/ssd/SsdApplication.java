package com.sliit.ssd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring Boot application main class
 * Authors: Wellala S. S.(IT17009096) | M. A Ashhar Ahamed (IT17043588)
 */
@SpringBootApplication
@ImportResource("classpath:WebContentInterceptor.xml")
public class SsdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsdApplication.class, args);
    }

}
