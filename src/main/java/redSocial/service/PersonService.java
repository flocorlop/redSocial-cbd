package redSocial.service;

import java.util.List;
import java.util.Set;

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
	
	public Person findUploadedbyByPostID(@Param("id")int  id) {
		return personRepository.findUploadedbyByPostID(id);
		
	}
	public Set<Person> findLikedbyByPostID(@Param("id")int  id) {
		return personRepository.findLikedbyByPostID(id);
		
	}
	
	public Integer findPIdByUsername(@Param("personUsername")String personUsername)  {
		return this.personRepository.findPIdByUsername(personUsername);
	}
	public Person findPById(@Param("id")int  id)  {
		return this.personRepository.findPById(id);
	}
}
