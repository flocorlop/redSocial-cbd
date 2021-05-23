package redSocial.model;

import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Post")
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	
	private String text;
	private int likes;
	@Relationship(type = "LIKED_BY", direction = Relationship.INCOMING)
	private Set<Person> likedBy;
	@Relationship(type = "UPLOADED_BY", direction = Relationship.INCOMING)
	private Person uploadedBy;

	
	public Post(int likes,String text, Set<Person> likedBy, Person uploadedBy) {
		super();
		this.likes = likes;
		this.text=text;
		this.likedBy = likedBy;
		this.uploadedBy = uploadedBy;
	}

	public Post() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Set<Person> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(Set<Person> likedBy) {
		this.likedBy = likedBy;
	}

	public Person getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(Person uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}