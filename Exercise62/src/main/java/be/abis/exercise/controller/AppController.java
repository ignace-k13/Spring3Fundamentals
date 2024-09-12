package be.abis.exercise.controller;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {
     
	@Autowired
	TrainingService trainingService;

	@GetMapping("/")
	public String showLogin(Model model){
		Person p = new Person();
		model.addAttribute("person",p);
		return "login";
	}

	@PostMapping("/login")
	public String handleLogin(Model model, @ModelAttribute("person") Person person, RedirectAttributes redirectAttrs){
		Person loggedInPerson = trainingService.getPersonService().findPerson(person.getEmailAddress(),person.getPassword());
		System.out.println(loggedInPerson);
		redirectAttrs.addFlashAttribute("loggedInPerson",loggedInPerson);
		return "redirect:/welcome";
	}

	@GetMapping("/welcome")
	public String welcomePerson(Model model, @ModelAttribute("loggedInPerson") Person p){
		System.out.println(p);
		model.addAttribute("fullName",p.getFirstName()+" "+p.getLastName());

		Course course = trainingService.getCourseService().findCourse(7900);
		model.addAttribute("course", course);

		return "welcome";
	}


}
