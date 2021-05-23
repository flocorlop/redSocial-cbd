package redSocial.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.Id;

@RelationshipEntity(type = "INTERESTED_IN")
public class Interest {
	@Id
	private Long relationshipId;
//	    @Property  private String title;
	@EndNode
	private Hobby hobby;
	@StartNode
	private Person person;
	
	public Hobby getHobby() {
		return hobby;
	}
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}