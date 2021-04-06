package redSocial.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import redSocial.model.Person;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

}
