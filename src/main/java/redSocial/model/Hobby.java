package redSocial.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.stereotype.Component;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node("Hobby")
public class Hobby {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Relationship(type = "INTERESTED_IN", direction = Relationship.INCOMING)
	private Set<Person> interested;

	
	public Hobby() {
		super();
	}
	public Hobby(String name) {
		super();
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
/*public Set<Person> getInterested() {
		return interested;
	}
	public void setInterested(Set<Person> interested) {
		this.interested = interested;
	}*/


}