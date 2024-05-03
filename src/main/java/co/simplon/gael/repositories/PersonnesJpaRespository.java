package co.simplon.gael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.gael.entities.Personne;

@Repository
public interface PersonnesJpaRespository extends JpaRepository<Personne, String>{

}
