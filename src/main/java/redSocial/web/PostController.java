package redSocial.web;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import redSocial.model.Person;
import redSocial.model.Post;
import redSocial.service.PersonService;
import redSocial.service.PostService;
import javax.validation.Valid;

@Controller
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
	public String getAllPosts(final Map<String, Object> model) {
		List<Post> results = this.postService.getPosts();
		model.put("results", results);
		return "posts/allPosts";
	}

	@GetMapping("/posts/{id}")
	public String getPost(@RequestBody @PathVariable("id") int id, final Map<String, Object> model) {
		String res = "posts/postDetails";
		Post p = this.postService.getPostById(id);
		Person uploadedBy = this.personService.findUploadedbyByPostID(id);
		Set<Person> likedBy = this.personService.findLikedbyByPostID(id);
		model.put("post", p);
		model.put("uploadedBy", uploadedBy);
		model.put("likedBy", likedBy);
		return res;
	}

	@GetMapping("{myself}/my-posts")
	public String getMyPosts(@RequestBody @PathVariable("myself") String myUsername,
			final Map<String, Object> model) {
		// un for de lista con las relaciones que van aparte
		Set<Post> results = new HashSet<>();
		Set<Post> myPosts = this.postService.getPostsByUsername(myUsername);
		
		for (Post p : myPosts) {
			Set<Person> likers = this.personService.findLikedbyByPostID(p.getId().intValue());
			results.add(p);
			model.put("likers", likers);
			
		}

		model.put("results", results);
		
		return "posts/myPosts";
		
	}

//	@GetMapping("/posts/{id}/likers")
//	public Set<Person> getLikersByPostID(@RequestBody @PathVariable("id") int id) {
//		return personService.findLikedbyByPostID(id);
//	}

	// posts
	@PostMapping("{myself}/posts/new")
	public Post postPost(@RequestBody @Valid Post p, @PathVariable("myself") String myUsername) {
		Person me = personService.findByUsername(myUsername);
		Set<Person> set = new HashSet<Person>();
		p.setLikedBy(set);
		p.setUploadedBy(me);
		System.out.println("Nuevo post: likes " + p.getLikes() + ",texto " + p.getText() + ",gustado " + p.getLikedBy()
				+ ",subido por " + p.getUploadedBy().getUsername());

		return this.postService.savePost(p);

	}
	
	@GetMapping(value = "{myself}/posts/{id}/edit") // el mecanico quiere actualizar cita
	public String initUpdatePost(@PathVariable("myself") String myUsername, @PathVariable("id") int id,
			final ModelMap model) {
		Post postLiked = postService.getPostById(id);
		model.addAttribute(postLiked);
		Person uploadedBy = personService.findUploadedbyByPostID(id);

		if (!(myUsername.equals(uploadedBy.getUsername()))) { // comprobar que no es otro mecanico que quiere acceder
			return "exception";
		}
		return "posts/editPost";
	}
	@PostMapping("{myself}/posts/{id}/edit")
	public String editPost(@Valid final Post p, @PathVariable("myself") String myUsername,
			@PathVariable("id") int id, final Map<String, Object> model, final BindingResult result) {
		Person me = personService.findByUsername(myUsername);
		Post postLiked = postService.getPostById(id);
		Person uploadedBy = personService.findUploadedbyByPostID(id);

		Set<Person> likers = personService.findLikedbyByPostID(id);

		if ((me.getUsername()).equals(uploadedBy.getUsername())) {
			System.out.println("texto anterior: " + postLiked.getText());
			postLiked.setText(p.getText());
			postLiked.setUploadedBy(uploadedBy);
			postLiked.setLikedBy(likers);
			postService.savePost(postLiked);
			System.out.println("texto ahora: " + postLiked.getText());
			return "redirect:/posts/";
		} else {
			System.out.println("no puedes editar el post que no es tuyo");
			return "posts/editPost";
		}
	}

	@PostMapping("{myself}/posts/{id}/delete")
	public void deletePost(@PathVariable("myself") String myUsername, @PathVariable("id") int id) {
		Person me = personService.findByUsername(myUsername);
		Post postLiked = postService.getPostById(id);
		Person uploadedBy = personService.findUploadedbyByPostID(id);

		if ((me.getUsername()).equals(uploadedBy.getUsername())) {

			postService.deletePost(postLiked.getId().intValue());
			System.out.println("borrado el post");
		} else {
			System.out.println("no puedes borrar el post que no es tuyo");
		}
	}

	@PostMapping("{myself}/posts/{id}/like")
	public String likePost(@PathVariable("myself") String myUsername, @PathVariable("id") int id) {
		Person me = personService.findByUsername(myUsername);
		Post postLiked = postService.getPostById(id);
		Person uploadedBy = personService.findUploadedbyByPostID(id);
		Set<Person> likers = personService.findLikedbyByPostID(id);

		System.out.println("likes anteriores" + postLiked.getLikes() + ", " + likers +"yo:" +me);
		if (likers == null) {
			likers = new HashSet<>();
			likers.add(me);
			postLiked.setLikedBy(likers);
		}else {
			likers.add(me);
			postLiked.setLikedBy(likers);
			postLiked.setLikes(postLiked.getLikes() + 1);
			postLiked.setUploadedBy(uploadedBy);
			
			
			System.out.println("me gusta dado, ahora tiene:" + postLiked.getLikes() + " lista: " + likers + ", subido por: "
					+ postLiked.getUploadedBy());
		}
		
		postService.savePost(postLiked);
		return "redirect:/posts/";
	}

	// FILTERS
	@GetMapping("/posts/filters/likes/{num}")
	public String filterPostsNumLikes(@RequestBody @PathVariable("num") int num,final Map<String, Object> model) {
		Set<Post> results = this.postService.getPostsByNumLikes(num);
		
		for (Post p : results) {
			Set<Person> likers = this.personService.findLikedbyByPostID(p.getId().intValue());
		
			model.put("likers", likers);
			Person uploadedBy = this.personService.findUploadedbyByPostID(p.getId().intValue());
			model.put("uploadedBy", uploadedBy);
			results.add(p);
		}
		model.put("results", results);
		return "posts/filterNumLikes";
		// los posts que tengan >= a ese numero de likes
	}

	// SEARCHES
	@GetMapping("/posts/searchByText/")
	public String searchPostByText(@RequestParam String text, final Map<String, Object> model) {
		Set<Post> results =  this.postService.searchPostByText(text);
		
		for (Post p : results) {
			Set<Person> likers = this.personService.findLikedbyByPostID(p.getId().intValue());
			results.add(p);
			model.put("likers", likers);
			Person uploadedBy = this.personService.findUploadedbyByPostID(p.getId().intValue());
			model.put("uploadedBy", uploadedBy);
		}
		model.put("results", results);
		return "posts/searchByText";

	}

	@GetMapping("/posts/containsText/")
	public String searchPostContainsText(@RequestParam String text, final Map<String, Object> model) {
		Set<Post> results = postService.searchPostContainsText(text);
		 for (Post p : results) {
				Set<Person> likers = this.personService.findLikedbyByPostID(p.getId().intValue());
				results.add(p);
				model.put("likers", likers);
				Person uploadedBy = this.personService.findUploadedbyByPostID(p.getId().intValue());
				model.put("uploadedBy", uploadedBy);
			}
		 model.put("results", results);
		 return "posts/containsText";
				 

	}

}
