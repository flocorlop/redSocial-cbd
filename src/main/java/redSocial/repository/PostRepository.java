package redSocial.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;

import redSocial.model.Post;

@EnableNeo4jRepositories
public interface PostRepository extends Neo4jRepository<Post, Long> {
	
	@Query("MATCH (n:Post) RETURN n")
	List<Post> getPosts();
}
