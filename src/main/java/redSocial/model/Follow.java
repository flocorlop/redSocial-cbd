package redSocial.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.Id;

@RelationshipEntity(type = "FOLLOWED_BY")
public class Follow {
	@Id
	private Long relationshipId;
//	    @Property  private String title;
	@EndNode
	private Person followed;
	@StartNode
	private Person follower;

	public Follow(Person follower, Person followed) {
		super();
		this.follower = follower;
		this.followed = followed;
	}

	public Long getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}

	public Person getFollower() {
		return follower;
	}

	public void setFollower(Person follower) {
		this.follower = follower;
	}

	public Person getFollowed() {
		return followed;
	}

	public void setFollowed(Person followed) {
		this.followed = followed;
	}
}
