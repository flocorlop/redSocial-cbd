package redSocial.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Post> getAllPosts(final Map<String, Object> model) {
		List<Post> results = this.postService.getPosts();
		model.put("results", results);
		return results;
	}

	@GetMapping("/posts/{id}")
	public Post getPost(@RequestBody @PathVariable("id") int id) {
		return postService.getPostById(id);
	}

	@GetMapping("{myself}/my-posts")
	public List<Post> getMyPosts(@RequestBody @PathVariable("myself") String myUsername,
			final Map<String, Object> model) {
		// un for de lista con las relaciones que van aparte
		List<Post> results = new ArrayList<>();
		List<Post> myPosts = this.postService.getPostsByUsername(myUsername);
		for (Post p : myPosts) {

			results.add(p);
		}

		model.put("results", results);
		return results;
		// esa seria la idea cada post tiene like y texto y por otra parte sacar los
		// likers
	}

	@GetMapping("/posts/{id}/likers")
	public Set<Person> getLikersByPostID(@RequestBody @PathVariable("id") int id) {
		return personService.findLikedbyByPostID(id);
	}

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

	@PostMapping("{myself}/posts/{id}/edit")
	public void editPost(@RequestBody @Valid Post p, @PathVariable("myself") String myUsername,
			@PathVariable("id") int id) {
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
		} else {
			System.out.println("no puedes editar el post que no es tuyo");
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
	public void likePost(@PathVariable("myself") String myUsername, @PathVariable("id") int id) {
		Person me = personService.findByUsername(myUsername);
		Post postLiked = postService.getPostById(id);
		Person uploadedBy = personService.findUploadedbyByPostID(id);
		Set<Person> likers = personService.findLikedbyByPostID(id);

		System.out.println("likes anteriores" + postLiked.getLikes() + ", " + likers);
		if (likers == null) {
			likers = new HashSet<>();
			likers.add(me);
			postLiked.setLikedBy(likers);
		} else {
			likers.add(me);
			postLiked.setLikedBy(likers);
		}
		postLiked.setUploadedBy(uploadedBy);
		postLiked.setLikes(postLiked.getLikes() + 1);
		postService.savePost(postLiked);
		System.out.println("me gusta dado, ahora tiene:" + postLiked.getLikes() + " lista: " + likers + ", subido por: "
				+ postLiked.getUploadedBy());
	}

	// FILTERS
	@GetMapping("/posts/filters/likes/{num}")
	public Post filterPostsNumLikes(@RequestBody @PathVariable("num") int num) {
		return postService.getPostsByNumLikes(num);
		// los posts que tengan >= a ese numero de likes
	}

	// SEARCHES
	@GetMapping("/posts/searchByText/")
	public Set<Post> searchPostByText(@RequestParam String text) {
		return postService.searchPostByText(text);

	}

	@GetMapping("/posts/containsText/")
	public Set<Post> searchPostContainsText(@RequestParam String text) {
		return postService.searchPostContainsText(text);

	}

}
