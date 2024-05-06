package co.simplon.gael.services;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import co.simplon.gael.dtos.PersonCreate;
import co.simplon.gael.dtos.PersonUpdate;
import co.simplon.gael.entities.Person;
import co.simplon.gael.repositories.PersonsRespository;

@Service
public class PersonnesService {
    
    public final PersonsRespository repository;
    
    public PersonnesService(PersonsRespository repository) {
	this.repository = repository;
    }

    public List<Person> findPersonnes() {
	return repository.findAll();
    }

    public Person create(PersonCreate input) {
	Person person = new Person();
	person.setFirstname(input.firstname());
	person.setLastname(input.lastname());
	person.setAddress(input.address());
	person.setCity(input.city());
	person.setZip(input.zip());
	person.setPhone(input.phone());
	person.setEmail(input.email());
	return repository.saveAndFlush(person);
    }

    public void deleteAll() {
	repository.deleteAll();
    }

    public void deleteOne(String input) {
	repository.deleteById(input);
    }

    public Person update(PersonUpdate input) {
	if (repository.findById(input.firstname()).isPresent()) {
	    Person person = repository.findById(input.firstname()).get();
	    if (input.address() != null) {person.setAddress(input.address());}
	    if (input.city() != null) {person.setCity(input.city());}
	    if (input.zip() != null) {person.setZip(input.zip());}
	    if (input.email() != null) {person.setEmail(input.email());}
	    if (input.phone() != null) {person.setPhone(input.phone());}
	    return repository.saveAndFlush(person);
	} else {
	    return null;
	}
    }

    public Person findOne(String id) {
	return repository.findById(id).get();
    }

}
