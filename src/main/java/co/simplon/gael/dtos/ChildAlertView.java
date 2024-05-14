package co.simplon.gael.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class ChildAlertView {
    
    private String firstname;
    private String lastname;
    private Integer age;
    private List<PersonIdentity> family;
    
    @AllArgsConstructor
    public static class PersonIdentity {
		String firstname;
		String lastname;
		
	}
    
}
