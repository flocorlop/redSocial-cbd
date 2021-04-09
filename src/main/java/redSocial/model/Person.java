package redSocial.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Person {
 
  @org.neo4j.ogm.annotation.Id @org.neo4j.ogm.annotation.GeneratedValue private Long id;

  private String firstName;
  private String lastName;
  private String username;
  
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
}