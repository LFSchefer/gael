package co.simplon.gael.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.dtos.CreateMedicalRecord;
import co.simplon.gael.dtos.PersonAllergies;
import co.simplon.gael.dtos.PersonMedicalRecord;
import co.simplon.gael.dtos.PersonMedications;
import co.simplon.gael.entities.MedicalRecord;
import co.simplon.gael.services.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/medicalrecord")
@AllArgsConstructor
public class MedicalRecordController {
    
    private final MedicalRecordService service;

    @GetMapping()
    public ResponseEntity<List<MedicalRecord>> findAll() {
	return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("medications/{firstname}")
    public ResponseEntity<PersonMedications> personMedication(@PathVariable("firstname")String firstname) {
	return new ResponseEntity<>(service.findMedication(firstname), HttpStatus.OK);
    }
    
    @GetMapping("allergies/{firstname}")
    public ResponseEntity<PersonAllergies> personAllergies(@PathVariable("firstname") String firstname) {
	return new ResponseEntity<>(service.findAllergies(firstname), HttpStatus.OK);
    }
    
    @GetMapping("{firstname}")
    public ResponseEntity<PersonMedicalRecord> personMedicalRecord(@PathVariable("firstname") String firstname) {
	return new ResponseEntity<>(service.findMedicalRecord(firstname), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{firstname}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecord(@PathVariable("firstname") String firstname) {
	service.deleteRecord(firstname);
    }
    
    @PostMapping("create")
    public ResponseEntity<CreateMedicalRecord> createMedicalRecord(@RequestBody @Valid CreateMedicalRecord input) {
	return new ResponseEntity<>(service.createMedicalRecord(input), HttpStatus.CREATED);
    }
    
}
