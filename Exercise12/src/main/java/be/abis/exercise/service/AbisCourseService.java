package be.abis.exercise.service;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class AbisCourseService implements CourseService {

    @Autowired
    private CourseRepository cr;

    @Override
    public List<Course> findAllCourses() {
        return cr.findAllCourses();
    }

    @Override
    public Course findCourse(int id) {
        return cr.findCourse(id);
    }

    @Override
    public Course findCourse(String shortTitle) {
        return cr.findCourse(shortTitle);
    }

    @Override
    public void addCourse(Course c) {

    }

    @Override
    public void updateCourse(Course c) {

    }

    @Override
    public void deleteCourse(int id) {

    }




}
