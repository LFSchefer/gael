package co.simplon.gael.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ChildAlertView {
    
    private String firstname;
    private String lastname;
    private Integer age;
    private List<PersonIdentity> family;
    
    public ChildAlertView(String firstname, String lastname, Integer age) {
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
    }
    
    public ChildAlertView(String firstname, String lastname, Integer age, List<PersonIdentity> family) {
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
	this.family = family;
    }
    
    @AllArgsConstructor
    @Getter
    @ToString
    public static class PersonIdentity {
		String firstname;
		String lastname;
		
	}
    
}
