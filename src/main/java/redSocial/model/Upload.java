package redSocial.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.Id;

@RelationshipEntity(type = "UPLOADED_BY")
public class Upload {
	@Id
	private Long relationshipId;
//	    @Property  private String title;
	@EndNode
	private Person person;
	@StartNode
	private Post post;

	public Upload(Person person, Post post) {
		super();
		this.person = person;
		this.post = post;
	}

	public Long getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
