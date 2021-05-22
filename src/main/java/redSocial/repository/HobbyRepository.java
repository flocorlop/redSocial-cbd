package redSocial.repository;

import java.util.Set;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;


import redSocial.model.Hobby;

@Repository
public interface HobbyRepository extends Neo4jRepository<Hobby,Long>{

	//@Query("match (h:Hobby {id:$id}) return h") Hobby findById(@Param("id")Integer id);
	
	@Query("MATCH (p:Person {username:$personUsername})-[r1:INTERESTED]->(h:Hobby) return h")
	Set<Hobby> findHobbiesbyUsername(@Param("personUsername")String personUsername);
	@Query("MATCH (h:Hobby {name:$name}) return h")
	Hobby findByName(@Param("name")String name);


}
