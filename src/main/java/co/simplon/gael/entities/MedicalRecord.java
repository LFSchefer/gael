package co.simplon.gael.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="medicalrecords", schema="public")
@Data
public class MedicalRecord {

    @Id
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="lastname")
    private String lastname;
    
    @Column(name="birthdate")
    private String birthdate;
    
    public MedicalRecord() {
	
    }

    
    
}
