package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import java.util.List;


public interface CourseRepository {

	List<Course> findAllCourses();
	Course findCourse(int id);
	Course findCourse(String shortTitle);
	void addCourse(Course c);
	void updateCourse(Course c);
	void deleteCourse(int id);
}
