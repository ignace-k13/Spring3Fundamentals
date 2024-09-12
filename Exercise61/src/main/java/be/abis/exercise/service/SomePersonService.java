package be.abis.exercise.service;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
@Profile("dev")
public class SomePersonService implements PersonService {

    @Override
    public ArrayList<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person findPerson(int id) {
        Address a = new Address("Diestsevest",32,"3000","Leuven");
        Company c = new Company("Abis","016/455610","BE12345678",a);
        Person p = new Person(4,"Sandy","Schillebeeckx",44,"sschillebeeckx@abis.be","abis123","nl",c);
        return p;
    }

    @Override
    public Person findPerson(String emailAddress, String passWord) {
        Address a = new Address("Diestsevest",32,"3000","Leuven");
        Company c = new Company("Abis","016/455610","BE12345678",a);
        Person p = new Person(4,"Sandy","Schillebeeckx",44,"sschillebeeckx@abis.be","abis123","nl",c);
        return p;
    }

    @Override
    public void addPerson(Person p) throws IOException {

    }

    @Override
    public void deletePerson(int id) {

    }

    @Override
    public void changePassword(Person p, String newPswd) throws IOException {

    }
}
