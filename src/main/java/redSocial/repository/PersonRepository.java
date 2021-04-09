package redSocial.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import redSocial.model.Person;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
	
	@org.springframework.data.neo4j.annotation.Query("MATCH (n:Person) RETURN n")
	List<Person> getPersons();
}
