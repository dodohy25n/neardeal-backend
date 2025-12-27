package com.neardeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NeardealApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeardealApplication.class, args);
    }

}
