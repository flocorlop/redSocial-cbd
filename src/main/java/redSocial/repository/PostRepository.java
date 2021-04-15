package redSocial.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;

import redSocial.model.Person;
import redSocial.model.Post;

@EnableNeo4jRepositories
public interface PostRepository extends Neo4jRepository<Post, Long> {
	
	@Query("MATCH (n:Post)-[r:UPLOADED_BY]-(p:Person) RETURN n,r,p")
	List<Post> getPosts();
	
	@Query("CREATE (p:Post)-[r:UPLOADED_BY]->(pe:Person)")
	Post createRelUploaded(Post p, Person pe);
}
