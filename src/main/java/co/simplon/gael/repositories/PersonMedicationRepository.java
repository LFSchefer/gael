package co.simplon.gael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.gael.entities.PersonMedication;

@Repository
public interface PersonMedicationRepository extends JpaRepository<PersonMedication, Integer> {

}
