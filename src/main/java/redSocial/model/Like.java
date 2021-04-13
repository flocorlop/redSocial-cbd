package redSocial.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.Id;

@RelationshipEntity(type = "LIKED_BY")
public class Like {
	  	@Id   private Long relationshipId;
//	    @Property  private String title;
	    @StartNode private Person person;
	    @EndNode   private Post post;
		
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
