package be.abis.exercise;

import be.abis.exercise.exception.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.AbisTrainingService;
import be.abis.exercise.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("prod")
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
		assertEquals("WORKSHOP SQL",c.getShortTitle().toUpperCase().trim());
	}

	@Test
	public void testPersonViaEmailPassword(){
		Person p = trainingService.getPersonService().findPerson("mjones@abis.be","abc123");
		assertEquals("Mary",p.getFirstName());
	}

	@Test
	public void enrollPersonForSessionWhichIsOk() throws EnrollException {
		Person p = trainingService.getPersonService().findPerson(1);
		Course c = ((AbisTrainingService)trainingService).getCourseService().findCourse(7900);
		LocalDate date = LocalDate.now().plusDays(4);
		assertDoesNotThrow(()->trainingService.enrollForSession(p,c,date));

	}

	@Test
	public void enrollPersonForSessionThrowingException(){
		Person p = trainingService.getPersonService().findPerson(1);
		Course c = ((AbisTrainingService)trainingService).getCourseService().findCourse(7900);
		LocalDate date = LocalDate.now().minusDays(4);
		assertThrows(EnrollException.class,()->trainingService.enrollForSession(p,c,date));
	}
	

	
	

}
