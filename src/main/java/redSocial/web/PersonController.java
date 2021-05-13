package redSocial.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import redSocial.model.Person;
import redSocial.service.PersonService;

@Controller
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(final PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping("/persons/new")
	private Person savePerson(@RequestBody Person person) {
		return personService.save(person);
	}

//	@GetMapping("/persons")
//	public String initFindForm(Map<String, Object> model) {
//		List<Person> results=this.personService.getPersons();
//		model.put("results", results);
//		return "persons/listPersons";
//	}
	@GetMapping("/persons")
	private List<Person> getAllPersons() {
		return personService.getPersons();
	}

}
