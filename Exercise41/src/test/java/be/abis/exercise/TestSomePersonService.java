package be.abis.exercise;

import be.abis.exercise.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ActiveProfiles("dev")
public class TestSomePersonService {
	
	@Autowired
	PersonService personService;

	@Autowired
	ConfigurableEnvironment env;

	@Test
	public void person4ShouldBeCalledSandy(){
		String firstName = personService.findPerson("sschillebeeckx@abis.be","abc123").getFirstName();
		assertEquals("Sandy",firstName);
	}


}
