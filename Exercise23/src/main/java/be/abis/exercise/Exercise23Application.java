package be.abis.exercise;

import be.abis.exercise.service.AbisTrainingService;
import be.abis.exercise.service.CourseService;
import be.abis.exercise.service.PersonService;
import be.abis.exercise.service.TrainingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Exercise23Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise23Application.class, args);
    }

    @Bean(initMethod="init")
    public TrainingService abisTrainingService(CourseService cs, PersonService ps){
        AbisTrainingService ts = new AbisTrainingService(cs);
        ts.setWelcomeMessage("Welcome to the Abis Training Service");
        ts.setPersonService(ps);
        return ts;
    }
}
