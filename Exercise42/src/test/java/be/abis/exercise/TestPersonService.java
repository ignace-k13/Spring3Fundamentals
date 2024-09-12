package be.abis.exercise;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("prod")
public class TestPersonService {
	
	@Autowired
	PersonService personService;

	@Test
	@Order(1)
	public void person1ShouldBeCalledJohn(){
		String firstName = personService.findPerson(1).getFirstName();
		assertEquals("John",firstName);
	}

	@Test
	@Order(2)
	public void thereShouldBe3PersonsInTheFile(){
		int nrOfPersons = personService.getAllPersons().size();
		assertEquals(3,nrOfPersons);
	}

	@Test
	@Order(3)
	public void addNewPerson() throws IOException {
		Address a = new Address("Diestsevest",32,"3000","Leuven");
		Company c = new Company("Abis","016/455610","BE12345678",a);
		Person p = new Person(4,"Sandy","Schillebeeckx",43,"sschillebeeckx@abis.be","abis123","nl",c);
		personService.addPerson(p);
	}

	@Test
	@Order(4)
	public void changePassWordOfAddedPerson() throws IOException {
		Person p = personService.findPerson("sschillebeeckx@abis.be","abis123");
		personService.changePassword(p,"blabla");
	}

	@Test
	@Order(5)
	public void deleteAddedPerson(){
		personService.deletePerson(4);
	}


}
