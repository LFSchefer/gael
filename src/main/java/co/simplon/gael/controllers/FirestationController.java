package co.simplon.gael.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.entities.Firestation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/firestation")
@CrossOrigin("*")
public class FirestationController {

    @GetMapping("/test")
    public String coucou(){
        return "coucou";
    }
    
    @GetMapping("/all")
    public List<Firestation>  getAll() {
	return service.getAll();
    }
    
}
