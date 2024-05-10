package co.simplon.gael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.gael.entities.PersonAllergie;

@Repository
public interface PersonAllergieRepository extends JpaRepository<PersonAllergie, Integer> {

}
