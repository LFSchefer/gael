package co.simplon.gael.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="allergies")
@Data
public class Allergie {

    @Id
    @Column(name="allergies_name")
    private String allergies_name;
}
