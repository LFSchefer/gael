package co.simplon.gael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.gael.entities.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, String>{

}
