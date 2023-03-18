package com.rouvsen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//security inactive
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)

//Auditing
@EnableJpaAuditing(auditorAwareRef = "auditorAware")

public class SpringBootApp2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp2Application.class, args);
    }
}