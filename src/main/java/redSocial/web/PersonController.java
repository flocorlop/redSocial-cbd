package redSocial.web;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import redSocial.model.Hobby;
import redSocial.model.Person;
import redSocial.service.HobbyService;
import redSocial.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {

	private PersonService personService;
	private HobbyService hobbyService;
	
	private static final String VIEWS_PERSON_CREATE_OR_UPDATE_FORM = "persons/createOrUpdatePersonForm";

	
	@Autowired
    public PersonController(final PersonService personService, final HobbyService hobbyService) {
    	this.personService = personService;
    	this.hobbyService = hobbyService;	
    }
	
	@GetMapping(value = "/new")
	public String initCreationForm(Map<String, Object> model) {
		Person p = new Person();
		model.put("person", p);
		return VIEWS_PERSON_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/new")
	public String processCreationForm(Person p, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_PERSON_CREATE_OR_UPDATE_FORM;
		}
		else {
//			Set<Person> eP = new HashSet<>(); 
//			Set<Hobby> eH = new HashSet<>(); 
			//p.setFollowers(eP);p.setFollows(eP);
			//;p.setHobbies(eH);
			//System.out.println(p.getFirstName()+p.getLastName()+p.getUsername()+p.getFollowers()+p.getFollows()+p.getHobbies());
			this.personService.savePerson(p);
			return "redirect:/persons/";
		}
	}
	
	
	@GetMapping("/{myself}/{username}/follow")
	private String followPerson(@PathVariable("username") String PersonUsername,@PathVariable("myself") String Myself) {
		
		Person me = personService.findByUsername(Myself);
		Person you = personService.findByUsername(PersonUsername);
		
		Set<Hobby> mHobbies = hobbyService.findHobbiesbyUsername(Myself);
		Set<Hobby> yHobbies = hobbyService.findHobbiesbyUsername(PersonUsername);

		me.setHobbies(mHobbies);
		you.setHobbies(yHobbies);

		Set<Person> follows = personService.findFollowsbyUsername(Myself);
		Set<Person> yFollows = personService.findFollowsbyUsername(PersonUsername);
		you.setFollows(yFollows);
		
		for(Person p : follows) {
			Set<Hobby> pHobbies = hobbyService.findHobbiesbyUsername(p.getUsername());
			Set<Person> pFollows = personService.findFollowsbyUsername(p.getUsername());
			p.setHobbies(pHobbies);
			p.setFollows(pFollows);
		}
		
		follows.add(you);
		me.setFollows(follows);
		
		personService.savePerson(me);
		personService.savePerson(you);
		
		return "redirect:/persons/";

		}
	
	@RequestMapping("/")
    public String findAllPersons(Model model) {
    	Iterable<Person> persons = this.personService.getPersons();
    	model.addAttribute("persons", persons);
    	return "persons/personsList";
    }
	
	@GetMapping("/{username}")
    public String getDetails(Model model, @PathVariable("username") String PersonUsername) {
		Person p = this.personService.findByUsername(PersonUsername);
		Set<Hobby> h = this.hobbyService.findHobbiesbyUsername(PersonUsername); 
		model.addAttribute("p", p);
		model.addAttribute("h", h);
    	return "persons/personDetails";
    }
	
	@GetMapping("/{id}/delete")
	public String deleteHobby(@PathVariable("id") int id) {
		personService.deletePersonbyId((long)id);
		return "redirect:/persons/";
	}
	
	@GetMapping(value = "/{id}/edit")
	public String initEditForm(Map<String, Object> model,@PathVariable("id") int id) {
		Person p = personService.findById(id);
		model.put("p", p);
		return "persons/editPersonForm";
	}
	
	
	@PostMapping(value = "/{id}/edit")
	public String processEditForm(Person p, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_PERSON_CREATE_OR_UPDATE_FORM;
		}
		else {
			System.out.println(p.getFirstName()+p.getLastName()+p.getUsername()+p.getFollows()+p.getHobbies());
			this.personService.savePerson(p);
			return "redirect:/persons/";
		}
	}
	
	
}
