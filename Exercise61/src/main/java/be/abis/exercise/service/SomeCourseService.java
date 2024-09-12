package be.abis.exercise.service;

import be.abis.exercise.model.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("some")
public class SomeCourseService implements CourseService{

    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    @Override
    public Course findCourse(int id) {
        return new Course("7900","Test Course","Test Course",1,300);
    }

    @Override
    public Course findCourse(String shortTitle) {
        return null;
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
