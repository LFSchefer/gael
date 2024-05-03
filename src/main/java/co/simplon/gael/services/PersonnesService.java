package co.simplon.gael.services;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import co.simplon.gael.dots.PersonCreate;
import co.simplon.gael.dots.PersonImport;
import co.simplon.gael.dots.PersonUpdate;
import co.simplon.gael.entities.Personne;
import co.simplon.gael.repositories.PersonnesJpaRespository;

@Service
public class PersonnesService {
    
    public final PersonnesJpaRespository repository;
    
    public PersonnesService(PersonnesJpaRespository repository) {
	this.repository = repository;
    }

    public List<Personne> getPersonnes() {
	return repository.findAll();
    }

    public Personne create(PersonCreate input) {
	Personne personne = new Personne();
	personne.setFirstname(input.firstname());
	personne.setLastname(input.lastname());
	personne.setAddress(input.address());
	personne.setCity(input.city());
	personne.setZip(input.zip());
	personne.setPhone(input.phone());
	personne.setEmail(input.email());
	return repository.saveAndFlush(personne);
    }

    public void deleteAll() {
	repository.deleteAll();
    }

    public void delete(String input) {
	repository.deleteById(input);
    }

    public Personne update(String id, PersonUpdate input) {
	if (repository.findById(id).isPresent()) {
	    Personne personne = repository.findById(id).get();
	    if (input.address() != null) {personne.setAddress(input.address());}
	    if (input.city() != null) {personne.setCity(input.city());}
	    if (input.zip() != null) {personne.setZip(input.zip());}
	    if (input.email() != null) {personne.setEmail(input.email());}
	    if (input.phone() != null) {personne.setPhone(input.phone());}
	    return repository.saveAndFlush(personne);
	} else {
	    return null;
	}
    }

    public Personne getOne(String id) {
	return repository.findById(id).get();
    }

    public void importPersonnes() {
	RestClient restClient = RestClient.create();
	List<PersonImport> importedPersonnes = restClient.get().uri(
		"/home/lf/code/LFSchefer/test_code/spring_gael/temp/data.json")
		.retrieve().body(new ParameterizedTypeReference<>() {
		});
    }

}
