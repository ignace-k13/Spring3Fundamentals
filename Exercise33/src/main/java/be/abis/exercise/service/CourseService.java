package be.abis.exercise.service;

import be.abis.exercise.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourses();
    Course findCourse(int id);
    Course findCourse(String shortTitle);
    void addCourse(Course c);
    void updateCourse(Course c);
    void deleteCourse(int id);

}
