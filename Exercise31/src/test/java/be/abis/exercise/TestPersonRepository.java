package be.abis.exercise;

import be.abis.exercise.model.Person;
import be.abis.exercise.repository.FilePersonRepository;
import be.abis.exercise.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPersonRepository {
	
	PersonRepository pr;
	
	@BeforeEach
	public void setUp() {
		pr=new FilePersonRepository();
	}
	
	@Test
	public void startSizeOfFileIs3() {
		int size = pr.getAllPersons().size();
		assertEquals(3,size);
	}
	
	@Test
	public void person1isJohn() {
		Person p = pr.findPerson(1);
		assertEquals("John",p.getFirstName());
	}
	
	@Test
	public void personViaMailAndPwdisMary() {
		Person p = pr.findPerson("mjones@abis.be","abc123");
		assertEquals("Mary",p.getFirstName());
	}
	
	

}
