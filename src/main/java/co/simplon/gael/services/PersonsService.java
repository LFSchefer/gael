package co.simplon.gael.services;

import java.util.List;

import co.simplon.gael.dtos.PersonCreate;
import co.simplon.gael.dtos.PersonUpdate;
import co.simplon.gael.entities.Person;

public interface PersonsService {
    
    List<Person> findPersons();
    
    Person findOne(String id);
    
    Person create(PersonCreate input);
    
    void deleteAll();
    
    void deleteOne(String id);
    
    Person update(PersonUpdate input);

}
