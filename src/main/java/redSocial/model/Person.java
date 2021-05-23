package redSocial.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.stereotype.Component;
import org.neo4j.ogm.annotation.Relationship;
import java.util.Set;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Person")
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String username;
	
	@Relationship(type="INTERESTED_IN",direction=Relationship.OUTGOING)
	private Set<Hobby> interested;
	
	@Relationship(type="FOLLOWS",direction=Relationship.OUTGOING)
	private Set<Person> follows;
	

	public Person(String firstName, String lastName, String username, Set<Hobby> hobbies, Set<Person> follows) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.interested = hobbies;
		this.follows = follows;
	
	}

	public Person() {
		super();
	}

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
		return interested;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.interested = hobbies;
	}

	public Set<Person> getFollows() {
		return follows;
	}

	public void setFollows(Set<Person> follows) {
		this.follows = follows;
	}

	
	
}