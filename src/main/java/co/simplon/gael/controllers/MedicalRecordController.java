package co.simplon.gael.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.dtos.PersonMedication;
import co.simplon.gael.entities.MedicalRecord;
import co.simplon.gael.services.MedicalRecordService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/medication")
@AllArgsConstructor
public class MedicalRecordController {
    
    private final MedicalRecordService service;

    @GetMapping()
    public ResponseEntity<List<MedicalRecord>> findAll() {
	return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{firstname}")
    public ResponseEntity<PersonMedication> personMedication(@PathVariable("firstname")String firstname) {
	return new ResponseEntity<>(service.findMedication(firstname), HttpStatus.OK);
    }
}
