package be.abis.exercise;

import be.abis.exercise.model.Course;
import be.abis.exercise.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("dev")
public class TestCourseService {
	
	@Autowired
	@Qualifier("abis")
	CourseService courseService;
	
	@Test
	public void course7900isWorkshopSQL() {
		Course c = courseService.findCourse(7900);
		assertEquals("WORKSHOP SQL",c.getShortTitle().toUpperCase().trim());
	}


}
