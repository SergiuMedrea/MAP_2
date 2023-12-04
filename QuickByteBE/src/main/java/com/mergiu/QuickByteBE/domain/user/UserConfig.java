package com.mergiu.QuickByteBE.domain.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User dinu = new User(
                    "Dinu",
                    "Tiban",
                    "0740123456"
            );

            User adi = new User(
                    "Adi",
                    "Toader",
                    "0740123456"
            );

            repository.saveAll(
                    List.of(dinu, adi)
            );
        };
    }
}
