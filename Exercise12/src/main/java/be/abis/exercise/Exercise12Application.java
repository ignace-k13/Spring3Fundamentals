package be.abis.exercise;

import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;
import be.abis.exercise.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.beans.BeanProperty;

@SpringBootApplication
public class Exercise12Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise12Application.class, args);
    }

}
