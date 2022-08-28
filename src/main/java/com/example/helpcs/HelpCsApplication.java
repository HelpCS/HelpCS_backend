package com.example.helpcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HelpCsApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(HelpCsApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);

    }

}
