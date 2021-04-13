package redSocial.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Person")
public class Person {
 
  @Id @GeneratedValue private Long id;

  private String firstName;
  private String lastName;
  private String username;
  
  
  public Person(String firstName, String lastName, String username) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
}

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