package co.simplon.gael.dtos;

import java.util.List;

import lombok.Data;

@Data
public class PersonMedicalRecord {

    private String firstname;
    private String lastname;
    private String birthday;
    private List<String> medications;
    private List<String> allergies;
    
}
