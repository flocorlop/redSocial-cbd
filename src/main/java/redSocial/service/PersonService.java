package redSocial.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import redSocial.model.Hobby;
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
	
	public void deletePersonbyId(long id) {
		personRepository.deleteById(id);
		
	}

	public Person findById(int id) {
		Optional<Person> p =  personRepository.findById((long)id);
		return p.get();
	}

	public Set<Hobby> findHobbiesbyUsername(String personUsername) {
		return personRepository.findHobbiesbyUsername(personUsername);
	}
	
	public Set<Person> findFollowsbyUsername(String personUsername) {
		return personRepository.findFollowsByUsername(personUsername);
	}

	public Set<Person> findFollowersbyUsername(String personUsername) {
		return personRepository.findFollowersbyUsername(personUsername);
	}

	public Set<Person> findPersonByHobbyName(String name) {
		return personRepository.findPersonByHobbyName(name);
	}
}
