package redSocial.repository;

import java.util.List;
import java.util.Set;

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
	Set<Post> getPostsByUsername(@Param("username")String username);
	
	@Query("MATCH (p:Post) WHERE p.likes >= $num RETURN p")
	Set<Post> getPostsByNumLikes(@Param("num") int num);
	
	@Query("MATCH(post:Post) WHERE post.text = $t RETURN post")
    Set<Post> getPostByText(String t);
	
	@Query("MATCH(post:Post) WHERE post.text CONTAINS $t RETURN post")
    Set<Post> getPostContainsText(String t);
}
