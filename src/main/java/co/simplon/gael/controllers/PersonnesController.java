package co.simplon.gael.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.dtos.PersonCreate;
import co.simplon.gael.dtos.PersonUpdate;
import co.simplon.gael.entities.Person;
import co.simplon.gael.services.PersonsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonnesController {
    
    private final PersonsService service;
    
    @GetMapping("/all")
    public ResponseEntity<List<Person>> findPersons() {
	final var personnes = service.findAll();
	return new ResponseEntity<>(personnes, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Person> findOne(@PathVariable String id) {
	try {
	    final var personne = service.findOne(id);
	    return new ResponseEntity<>(personne, HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

    }
    
    @PostMapping("/create")
    public ResponseEntity<Person> create(@RequestBody @Valid PersonCreate input) {
	final var personne = service.create(input);
	return new ResponseEntity<>(personne, HttpStatus.CREATED);
    }
    
    @GetMapping("/deleteall")
    public ResponseEntity<Void> deleteAll() {
	service.deleteAll();
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable String id) {
	try {
	    service.deleteOne(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
	}
    }
    
    @PutMapping("/update")
    public ResponseEntity<Person> update(@RequestBody PersonUpdate input) {
	final var update = service.update(input);
	return new ResponseEntity<>(update, HttpStatus.ACCEPTED);
    }

}

