package redSocial.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import redSocial.model.Post;
import redSocial.service.PostService;

@RestController
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(final PostService postService) {
		super();
		this.postService = postService;
	}

	@PostMapping("/posts/new")
	private Post savePost(@RequestBody Post p) {
		return postService.save(p);
	}

//	@GetMapping("/persons")
//	public String initFindForm(Map<String, Object> model) {
//		List<Person> results=this.personService.getPersons();
//		model.put("results", results);
//		return "persons/listPersons";
//	}
	@GetMapping("/posts")
	private List<Post> getAllPosts() {
		return postService.getPosts();
	}

}
