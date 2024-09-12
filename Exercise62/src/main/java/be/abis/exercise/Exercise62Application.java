package be.abis.exercise;

import be.abis.exercise.service.AbisTrainingService;
import be.abis.exercise.service.CourseService;
import be.abis.exercise.service.PersonService;
import be.abis.exercise.service.TrainingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:my.properties")
public class Exercise62Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise62Application.class, args);
    }

    @Bean(initMethod="init")
    public TrainingService abisTrainingService(@Qualifier("abis") CourseService cs, PersonService ps){
        AbisTrainingService ts = new AbisTrainingService(cs);
        ts.setWelcomeMessage("Welcome to the Abis Training Service");
        ts.setPersonService(ps);
        return ts;
    }
}
