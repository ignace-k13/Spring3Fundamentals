package be.abis.exercise.controller;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    TrainingService trainingService;

    @GetMapping("/persons/{id}")
    public Person fetchPerson(@PathVariable("id") int personId){
        Person p = trainingService.getPersonService().findPerson(personId);
        return p;
    }




}
