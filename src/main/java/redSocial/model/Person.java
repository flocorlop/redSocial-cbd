package redSocial.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
public class Person {
 
  @Id @GeneratedValue private Long id;

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