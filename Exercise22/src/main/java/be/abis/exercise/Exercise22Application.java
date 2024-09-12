package be.abis.exercise;

import be.abis.exercise.repository.FilePersonRepository;
import be.abis.exercise.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Exercise22Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise22Application.class, args);
    }

}
