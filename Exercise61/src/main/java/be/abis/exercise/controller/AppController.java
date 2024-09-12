package be.abis.exercise.controller;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
     
	@Autowired
	TrainingService trainingService;
	
	@GetMapping("/welcome")
	public String welcomePerson(Model model){
		Person p = trainingService.getPersonService().findPerson(3);
		model.addAttribute("fullName",p.getFirstName()+" "+p.getLastName());

		Course course = trainingService.getCourseService().findCourse(7900);
		model.addAttribute("course", course);

		return "welcome";
	}


}
