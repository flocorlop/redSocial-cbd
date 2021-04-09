package redSocial.model;

import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

@NodeEntity()
public class Post {
 
  @Id @GeneratedValue private Long id;

  private int likes;
  @Relationship(type= "LIKED_BY", direction = Relationship.INCOMING )
  private Set<Person> likedBy;
  @Relationship(type= "UPLOADED_BY", direction = Relationship.INCOMING )
  private Person uploadedBy;
  
  

}