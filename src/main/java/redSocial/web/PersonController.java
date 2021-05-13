package redSocial.web;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
//import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redSocial.model.Hobby;
import redSocial.model.Person;
import redSocial.repository.PersonRepository;
import redSocial.service.HobbyService;
import redSocial.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {

	private PersonService personService;
	
	@Autowired
    public PersonController(final PersonService personService) {
    	this.personService = personService;
    }
	
	@PostMapping("/new")
	private Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@PostMapping("/{myself}/{username}/follow")
	private void followPerson(@PathVariable("username") String PersonUsername,@PathVariable("myself") String myUsername) {
		Person followed = personService.findByUsername(PersonUsername);
		Person me = personService.findByUsername(myUsername);
		
		Set<Person> followers = followed.getFollowers();
		Set<Person> follows = me.getFollows();

		if (follows==null) {
			follows=new HashSet<>();
		}
		if (followers==null) {
			followers=new HashSet<>();
		}
		
		followers.add(me);
		follows.add(followed);
		me.setFollows(follows);
		followed.setFollowers(followers);
				
		personService.savePerson(me);
		personService.savePerson(followed);
		
	}
	
	@RequestMapping("/all")
    public String findAllPersons(Model model) {
    	Iterable<Person> persons = this.personService.getPersons();
    	model.addAttribute("persons", persons);
    	return "personsList";
    }

	

	
	
}
