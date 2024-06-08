package com.tool.codeskeletonhub;

import com.tool.codeskeletonhub.user.entity.User;
import com.tool.codeskeletonhub.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(final UserRepository userRepository) {
        return args -> IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new User("firstName" + i, "lastName" + i, "email" + i + "@example.com"))
                .forEach(userRepository::save);
    }
}
