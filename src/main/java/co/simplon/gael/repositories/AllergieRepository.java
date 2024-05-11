package co.simplon.gael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.gael.entities.Allergie;

@Repository
public interface AllergieRepository extends JpaRepository<Allergie, String> {

}
