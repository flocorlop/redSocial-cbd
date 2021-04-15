package redSocial.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import redSocial.model.Person;
import redSocial.model.Post;
import redSocial.service.PersonService;
import redSocial.service.PostService;

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

	@PostMapping("{myself}/posts/new")
	private Post postPost(Post p, @PathVariable("myself") String myUsername) {
		Person me = personService.findByUsername(myUsername);
		Set<Person> set = new HashSet<Person>();
		Post postn = new Post(p.getLikes(),p.getText(),set,me);
		
		return postService.save(postn);
	}

//	@GetMapping("/posts")
//	public String initFindForm(Map<String, Object> model) {
//		List<Post> results=this.postService.getPosts();
//		model.put("results", results);
//		return "posts/listPosts";
//	}

	@GetMapping("/posts")
	private List<Post> getAllPosts() {
		return postService.getPosts();
	}

}
