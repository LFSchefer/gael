package co.simplon.gael.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.dtos.ChildAlertView;
import co.simplon.gael.dtos.PhoneAlertView;
import co.simplon.gael.services.ComplexService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping()
@AllArgsConstructor
public class AlertController {

    ComplexService service;
    
    @GetMapping("/childAlert")
    public ResponseEntity<List<ChildAlertView>>  childAlert(@RequestParam("address") String input) {
	return new ResponseEntity<>(service.childAlert(input), HttpStatus.OK);
    }
    
    @GetMapping("/phoneAlert")
    public ResponseEntity<PhoneAlertView> getMethodName(@RequestParam("firestation") String firestationNumber) {
	return new ResponseEntity<>(service.phoneAlert(firestationNumber), HttpStatus.OK);
    }
    
}
