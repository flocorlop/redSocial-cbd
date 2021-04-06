package redSocial.web;

import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import redSocial.model.Person;
import redSocial.repository.PersonRepository;
import redSocial.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	private PersonService personService;
	
	@PostMapping("/persons/new")
	private Person savePerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
//	@GetMapping("/persons")
//	public String initFindForm(Map<String, Object> model) {
//		List<Person> pLs=this.personService.getPersons();
//		model.put("person", pLs);
//		return "persons/findPersons";
//	}
	@GetMapping("/persons")
	private List<Person> getAllPersons(){
		return personService.getPersons();
	}
	
	
}
