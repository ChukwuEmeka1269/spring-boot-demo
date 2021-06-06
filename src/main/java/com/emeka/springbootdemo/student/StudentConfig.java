package com.emeka.springbootdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student samuel = new Student(
                    "Samuel",
                    "sam@gmail.com",
                    LocalDate.of(1990, DECEMBER, 18)

            );
            Student dave = new Student(
                    "Dave",
                    "dave@gmail.com",
                    LocalDate.of(2001, DECEMBER, 18)
            );
            Student manuel = new Student(
                    "Manuel",
                    "manu@gmail.com",
                    LocalDate.of(1998, DECEMBER, 18)
            );

            repository.saveAll(
                    List.of(samuel,dave,manuel)
            );
        };
    }
}
