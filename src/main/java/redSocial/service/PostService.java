package redSocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redSocial.model.Post;
import redSocial.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	
	public Post save(Post p) {
		return postRepository.save(p);
	}
	public List<Post> getPosts() {
		return (List<Post>) postRepository.getPosts();
	}
}
