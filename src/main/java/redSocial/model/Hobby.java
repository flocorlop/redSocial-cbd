package redSocial.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.stereotype.Component;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
@Component
public class Hobby {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Set<Person> interested;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Person> getInterested() {
		return interested;
	}
	public void setInterested(Set<Person> interested) {
		this.interested = interested;
	}


}