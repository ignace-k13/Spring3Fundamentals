package be.abis.exercise;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.jdbc.JdbcTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("prod")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestJdbcCourseRepository {

	@Autowired CourseRepository cr;
	@Autowired  JdbcTemplate jdbcTemplate;

	Course newCourse;

	@BeforeEach
     public void init(){
		newCourse=new Course("9000","Spring","Spring Fundamentals",3,550.);
	}
	@Test
	@Order(1)
	public void numberOfCoursesInDBIs28() {
		int size = cr.findAllCourses().size();
		assertEquals(28,size);
	}
	
	@Test
	@Order(2)
	public void courseWithId7900isWorkshopSQL() {
		String title = cr.findCourse(7900).getShortTitle();
		assertEquals("Workshop SQL",title.trim());
	}

	@Test
	@Order(3)
	public void courseIdOfADFPLUSis7810() {
		String id = cr.findCourse("ADFPLUS").getCourseId();
		assertEquals("7810",id);
	}

	@Test
	@Order(4)
	public void insertingNewCourseWorks() {
		int linesBefore = JdbcTestUtils.countRowsInTable(jdbcTemplate,"abiscourses");
		cr.addCourse(newCourse);
		int linesAfter = JdbcTestUtils.countRowsInTable(jdbcTemplate,"abiscourses");
		assertEquals(1,linesAfter-linesBefore);
	}

	@Test
	@Order(5)
	public void updatingNewCourseWorks() {
		newCourse.setNumberOfDays(4);
		cr.updateCourse(newCourse);
		assertEquals(4,cr.findCourse(9000).getNumberOfDays());
	}

	@Test
	@Order(6)
	public void deletingNewCourseWorks() {
		int linesBefore = JdbcTestUtils.countRowsInTable(jdbcTemplate,"abiscourses");
		cr.deleteCourse(Integer.parseInt(newCourse.getCourseId()));
		int linesAfter = JdbcTestUtils.countRowsInTable(jdbcTemplate,"abiscourses");
		assertEquals(-1,linesAfter-linesBefore);
	}

	
	

}
