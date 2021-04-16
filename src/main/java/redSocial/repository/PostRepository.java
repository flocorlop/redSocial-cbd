package redSocial.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import redSocial.model.Person;
import redSocial.model.Post;

@EnableNeo4jRepositories
public interface PostRepository extends Neo4jRepository<Post, Long> {
	
	@Query("MATCH p=()-[]->() RETURN p")
	List<Post> getPosts();
	
	@Query("CREATE (p:Post)-[r:UPLOADED_BY]->(pe:Person)")
	Post createRelUploaded(Post p, Person pe);
	
	@Query("MATCH (pe:Person {username: $username}) <-[r:UPLOADED_BY]-(p:Post) RETURN p")
	List<Post> getPostsByUsername(@Param("username")String username);
}
