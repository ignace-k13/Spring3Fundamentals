package be.abis.exercise.service;

import be.abis.exercise.exception.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;

import java.time.LocalDate;
import java.util.List;

public class AbisTrainingService implements TrainingService {

    private String welcomeMessage;

    private PersonService personService;

    private CourseService courseService;


    public AbisTrainingService(CourseService courseService) {
        this.courseService = courseService;
    }


    public void init(){
        System.out.println("AbisTrainingService is ready for work!");
    }

    @Override
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

   public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    @Override
    public List<Course> showFollowedCourses(Person person) {
        return null;
    }

    @Override
    public void enrollForSession(Person person, Course course, LocalDate date) throws EnrollException {

    }
}
