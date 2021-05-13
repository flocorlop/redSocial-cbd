package redSocial.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.stereotype.Component;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
@Component
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String username;
	
	@Relationship(type="INTERESTED IN",direction=Relationship.OUTGOING)
	private Set<Hobby> hobbies;
	@Relationship(type="FOLLOWS",direction=Relationship.OUTGOING)
	private Set<Person> follows;
	@Relationship(type="FOLLOWED BY",direction=Relationship.INCOMING)
	private Set<Person> followers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	public Set<Person> getFollows() {
		return follows;
	}

	public void setFollows(Set<Person> follows) {
		this.follows = follows;
	}

	public Set<Person> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<Person> followers) {
		this.followers = followers;
	}
}