package com.example.helpcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HelpCsApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelpCsApplication.class, args);
    }

}
