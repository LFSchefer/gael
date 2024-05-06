package co.simplon.gael.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.dtos.FirestationCreate;
import co.simplon.gael.dtos.FirestationUpdate;
import co.simplon.gael.entities.Firestation;
import co.simplon.gael.services.FirestationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/firestation")
@AllArgsConstructor
public class FirestationController {
    
    private final FirestationService service;
    
    @GetMapping("/all")
    public ResponseEntity<List<Firestation>>  findAll() {
	final var firestations = service.findAll();
	return new ResponseEntity<>(firestations, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Firestation> create(@RequestBody @Valid FirestationCreate input) {
	final var firestation = service.create(input);
	return new ResponseEntity<>(firestation,HttpStatus.CREATED);
    }
    
    @PatchMapping("/update")
    public ResponseEntity<Firestation> update(@RequestBody FirestationUpdate input) {
	final var firestationUpdate = service.update(input);
	return new ResponseEntity<>(firestationUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
	service.delete(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
