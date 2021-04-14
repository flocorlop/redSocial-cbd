package redSocial.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import redSocial.model.Person;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {
	
	@Query("match (p) where p.username = $personUsername return p")
	Person findByUsername(@Param("personUsername")String personUsername);


}
