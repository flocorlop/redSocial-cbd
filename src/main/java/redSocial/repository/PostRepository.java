package redSocial.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import redSocial.model.Post;

@EnableNeo4jRepositories
public interface PostRepository extends Neo4jRepository<Post, Long> {
	
	@Query("MATCH n RETURN n")
	List<Post> getPosts();
	
	@Query("MATCH (p:Post) WHERE ID(p) = $id RETURN p")
	Post getPostById(@Param("id") int id);
	
	@Query("MATCH (pe:Person {username: $username}) <-[r1:UPLOADED_BY]-(p:Post) RETURN p")
	List<Post> getPostsByUsername(@Param("username")String username);
}
