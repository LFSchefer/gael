package co.simplon.gael.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="medications")
@Data
public class Medication {
    
    @Id
    @Column(name="medication_name")
    private String medication_name;
}
