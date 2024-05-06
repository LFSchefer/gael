package co.simplon.gael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.gael.entities.Person;
import co.simplon.gael.entities.PersonPK;

@Repository
public interface PersonsRespository extends JpaRepository<Person, String>{

}
