package redSocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redSocial.model.Person;
import redSocial.model.Post;
import redSocial.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public Post savePost(Post p) {
		return postRepository.save(p);
	}
	public Post createRelUploaded(Post p, Person pe) {
		return postRepository.createRelUploaded(p,pe);
	}
	public List<Post> getPosts() {
		return (List<Post>) postRepository.getPosts();
	}
	public List<Post> getPostsByUsername(String username) {
		return (List<Post>) postRepository.getPostsByUsername(username);
	}
}
