package co.simplon.gael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.gael.entities.Firestation;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation, String>{

}
