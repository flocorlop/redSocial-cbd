package redSocial.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import redSocial.model.Post;

public interface PostRepository extends Neo4jRepository<Post, Long> {
	
	@org.springframework.data.neo4j.annotation.Query("MATCH (n:Post) RETURN n")
	List<Post> getPosts();
}
