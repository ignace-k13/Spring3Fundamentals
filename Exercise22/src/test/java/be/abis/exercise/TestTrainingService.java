package be.abis.exercise;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.AbisTrainingService;
import be.abis.exercise.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TestTrainingService {
	
	@Autowired
	TrainingService trainingService;

	@Test
	public void testWelcomeMessage(){
		assertEquals("Welcome to the Abis Training Service",trainingService.getWelcomeMessage());
	}

	@Test
	public void course7900isWorkshopSQL() {
		Course c = ((AbisTrainingService)trainingService).getCourseService().findCourse(7900);
		assertEquals("WORKSHOP SQL",c.getShortTitle().toUpperCase());
	}

	@Test
	public void testPersonViaEmailPassword(){
		Person p = trainingService.getPersonService().findPerson("mjones@abis.be","abc123");
		assertEquals("Mary",p.getFirstName());
	}
	

	
	

}
