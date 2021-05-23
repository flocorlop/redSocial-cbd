package redSocial.repository;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import redSocial.model.Hobby;
import redSocial.model.Person;

@EnableNeo4jRepositories
public interface PersonRepository extends Neo4jRepository<Person, Long> {
	
	@Query("match (p) where p.username = $personUsername return p")
	Person findByUsername(@Param("personUsername")String personUsername);

	@Query("MATCH (p:Person {username:$personUsername})-[r1:INTERESTED]->(h:Hobby) return h")
	Set<Hobby> findHobbiesbyUsername(@Param("personUsername")String personUsername);
	
	@Query("MATCH (p:Person {username:$personUsername})-[r1:FOLLOWS]->(pe:Person) return pe")
	Set<Person> findFollowsByUsername(@Param("personUsername") String personUsername);

	@Query("MATCH (p:Person {username: $personUsername})-[r1:FOLLOWED_BY]->(pe:Person) return pe")
	Set<Person> findFollowersbyUsername(@Param("personUsername")String personUsername);

	@Query("MATCH (p:Person)-[r:INTERESTED]->(h:Hobby{name:$name}) return p")
	Set<Person> findPersonByHobbyName(@Param("name") String name);


}
