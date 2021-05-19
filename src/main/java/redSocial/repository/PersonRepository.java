package redSocial.repository;

import java.util.List;
import java.util.Set;

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

	@Query("MATCH (pe:Person) <-[r1:UPLOADED_BY]-(p:Post) WHERE ID(p) = $id RETURN pe")
	Person findUploadedbyByPostID(@Param("id")int  id);
	
	@Query("MATCH (pe:Person) <-[r1:LIKED_BY]-(p:Post) WHERE ID(p) = $id RETURN pe")
	Set<Person> findLikedbyByPostID(@Param("id")int  id);
	
	@Query("MATCH (n:Person) where n.username = $personUsername return ID(n)")
	Integer findPIdByUsername(@Param("username") String personUsername);
	
	@Query("match (n:Person) where ID(n) = $id return p")
	Person findPById(@Param("id")int id);
}
