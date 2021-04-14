package redSocial.web;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
//import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/{myself}/persons/{username}/follow")
	private void followPerson(@PathVariable("username") String PersonUsername,@PathVariable("myself") String myUsername) {
		Person followed = personRepository.findByUsername(PersonUsername);
		Person me = personRepository.findByUsername(myUsername);
		
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
				
		personRepository.save(me);
		personRepository.save(followed);
		
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
