package co.simplon.gael.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.dots.FirestationCreate;
import co.simplon.gael.dots.FirestationUpdate;
import co.simplon.gael.entities.Firestation;
import co.simplon.gael.services.FirestationService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/firestation")
@CrossOrigin("*")
public class FirestationController {
    
    FirestationService service;
    
    public FirestationController(FirestationService service) {
	this.service = service;
    }
    
    @GetMapping("/all")
    public List<Firestation>  getAll() {
	return service.getAll();
    }
    
    @PostMapping("/create")
    public Firestation create(@RequestBody @Valid FirestationCreate input) {
	return service.create(input);
    }
    
//    @PatchMapping("/update")
//    public Firestation update(@RequestParam String id, @RequestBody FirestationUpdate input) {
//	return service.update(id, input); 
//    }
    
    @PatchMapping("/update")
    public Firestation update(@RequestParam String id, @RequestParam String station) {
	return service.update(id, station); 
    }
    
    @DeleteMapping("/delete")
    public void delete(@RequestParam String id) {
	service.delete(id);
    }
}
