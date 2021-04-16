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

	@PostMapping("{myself}/posts/new")
	private Post postPost(@RequestBody @Valid Post p, @PathVariable("myself") String myUsername) {
		System.out.println("likes"+p.getLikes()+"texto"+p.getText()+"gustado"+p.getLikedBy()+"subido"+p.getUploadedBy());
		Person me = personService.findByUsername(myUsername);
		Set<Person> set = new HashSet<Person>();
		p.setLikedBy(set);
		p.setUploadedBy(me);
		
		return this.postService.savePost(p);
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
	
	@GetMapping("{myself}/my-posts")
	private List<Post> getMyPosts(@RequestBody @PathVariable("myself") String myUsername) {
		System.out.println("usuario"+myUsername);
		return this.postService.getPostsByUsername(myUsername);
	}

}
