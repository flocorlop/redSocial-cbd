package redSocial.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "LIKED_BY")
public class Like {
	  	@Id   private Long relationshipId;
//	    @Property  private String title;
	    @StartNode private Person person;
	    @EndNode   private Post post;
}
