package co.simplon.gael.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.dots.PersonCreate;
import co.simplon.gael.dots.PersonUpdate;
import co.simplon.gael.entities.Personne;
import co.simplon.gael.services.PersonnesService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/persons")
public class PersonnesController {
    
    private final PersonnesService service;
    
    public PersonnesController(PersonnesService service) {
	this.service = service;
    }
    
    @GetMapping("/import")
    void importPersonnes() {
	service.importPersonnes();
    }
    
    @GetMapping("/all")
    List<Personne> getPersonnes() {
	return service.getPersonnes();
    }
    
    @GetMapping("/get")
    Personne getOne(@RequestParam String id) {
	return service.getOne(id);
    }
    
    @PostMapping("/create") 
    @ResponseStatus(HttpStatus.ACCEPTED)
    Personne create(@RequestBody @Valid PersonCreate input) {
	return service.create(input);
    }
    
    @GetMapping("/deleteall")
    void deleteAll() {
	service.deleteAll();
    }
    
    @DeleteMapping("/delete")
    void delete(@RequestParam String id) {
	service.delete(id);
    }
    
    @PutMapping("/update")
    Personne update(@RequestParam String id, @RequestBody PersonUpdate input) {
	return service.update(id,input);
    }

}

