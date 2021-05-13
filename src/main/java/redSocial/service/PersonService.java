package redSocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import redSocial.model.Person;
import redSocial.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Transactional
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	public List<Person> getPersons() {
		return (List<Person>) personRepository.findAll();
	}
	public Person findByUsername(String personUsername) {
		return personRepository.findByUsername(personUsername);
	}
}
