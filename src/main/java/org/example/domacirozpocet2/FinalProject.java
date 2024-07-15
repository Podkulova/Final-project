package org.example.domacirozpocet2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FinalProject {

    public static void main(String[] args) {
        SpringApplication.run(FinalProject.class, args);
        log.info("Aplikace běží na adrese: http://localhost:8080/");
    }

}
