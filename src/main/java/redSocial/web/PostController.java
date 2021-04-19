package redSocial.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import redSocial.model.Person;
import redSocial.model.Post;
import redSocial.service.PersonService;
import redSocial.service.PostService;
import javax.validation.Valid;

@RestController
public class PostController {

	private final PostService postService;
	private final PersonService personService;

	@Autowired
	public PostController(final PostService postService, final PersonService personService) {
		super();
		this.postService = postService;
		this.personService = personService;
	}

	// gets
	@GetMapping("/posts")
	private List<Post> getAllPosts() {
		return postService.getPosts();
	}

	@GetMapping("/posts/{id}")
	private Post getPost(@RequestBody @PathVariable("id") int id) {
		return postService.getPostById(id);
	}

	@GetMapping("{myself}/my-posts")
	private List<Post> getMyPosts(@RequestBody @PathVariable("myself") String myUsername) {
		return this.postService.getPostsByUsername(myUsername);
	}

	// posts
	@PostMapping("{myself}/posts/new")
	private Post postPost(@RequestBody @Valid Post p, @PathVariable("myself") String myUsername) {
		Person me = personService.findByUsername(myUsername);
		Set<Person> set = new HashSet<Person>();
		p.setLikedBy(set);
		p.setUploadedBy(me);
		System.out.println("Nuevo post: likes" + p.getLikes() + ",texto" + p.getText() + ",gustado" + p.getLikedBy()
				+ ",subido" + p.getUploadedBy());

		return this.postService.savePost(p);

	}

	@PostMapping("{myself}/posts/{id}/like")
	private void likePost(@PathVariable("myself") String myUsername, @PathVariable("id") int id) {
		Person me = personService.findByUsername(myUsername);
		Post postLiked = postService.getPostById(id);
		Set<Person> likers = postLiked.getLikedBy();
		if (likers == null) {
			likers = new HashSet<>();
		}
		
		likers.add(me);
		postLiked.setLikedBy(likers);
		postService.savePost(postLiked);
		System.out.println("me gusta dado");
	}

}
