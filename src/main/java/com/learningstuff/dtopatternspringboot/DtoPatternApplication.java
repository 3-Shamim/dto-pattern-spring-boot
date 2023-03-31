package com.learningstuff.dtopatternspringboot;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningstuff.dtopatternspringboot.enums.Gender;
import com.learningstuff.dtopatternspringboot.models.User;
import com.learningstuff.dtopatternspringboot.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@SpringBootApplication
public class DtoPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtoPatternApplication.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper;
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository) {
        return args -> {

            if (userRepository.count() > 0) {
                log.info("Initial users already added.");
            } else {
                List<User> users = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    users.add(randomGenerateUser());
                }
                userRepository.saveAll(users);
                log.info("Initial users successfully added.");
            }

        };
    }

    private User randomGenerateUser() {
        return new User(
                0,
                randomStringGenerator(8),
                (int) (Math.random() * 20 + 15),
                Gender.getRandomGender(),
                randomStringGenerator(100)
        );
    }

    private String randomStringGenerator(int length) {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


}
