package redSocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import redSocial.model.Person;
import redSocial.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	public List<Person> getPersons() {
		return (List<Person>) personRepository.getPersons();
	}
	
	public Person findByUsername(@Param("personUsername")String personUsername) {
		return personRepository.findByUsername(personUsername);
	}
}
