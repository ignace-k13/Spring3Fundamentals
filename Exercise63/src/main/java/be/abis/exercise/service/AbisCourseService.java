package be.abis.exercise.service;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("abis")
public class AbisCourseService implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public Course findCourse(int id) {
        return courseRepository.findCourse(id);
    }

    @Override
    public Course findCourse(String shortTitle) {
        return courseRepository.findCourse(shortTitle);
    }

    @Override
    public void addCourse(Course c) {
        courseRepository.addCourse(c);
    }

    @Override
    public void updateCourse(Course c) {
        courseRepository.updateCourse(c);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteCourse(id);
    }




}
