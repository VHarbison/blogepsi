package hw5.databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("email")
public class User {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		
		this.lastname = lastname;
	}
  
}