package redSocial.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import redSocial.model.Person;

@EnableNeo4jRepositories
public interface PersonRepository extends Neo4jRepository<Person, Long> {
	
	@Query("MATCH (n:Person) RETURN n")
	List<Person> getPersons();

	@Query("match (p) where p.username = $personUsername return p")
	Person findByUsername(@Param("personUsername")String personUsername);
}
