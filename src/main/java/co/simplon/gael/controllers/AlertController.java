package co.simplon.gael.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.dtos.ChildAlertView;
import co.simplon.gael.dtos.CommunityEmails;
import co.simplon.gael.dtos.FireView;
import co.simplon.gael.dtos.FloodView;
import co.simplon.gael.dtos.PersonView;
import co.simplon.gael.dtos.PhoneAlertView;
import co.simplon.gael.services.ComplexService;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
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
    public ResponseEntity<PhoneAlertView> phoneAlert(@RequestParam("firestation") String firestationNumber) {
	return new ResponseEntity<>(service.phoneAlert(firestationNumber), HttpStatus.OK);
    }
    
    @GetMapping("communityEmail")
    public ResponseEntity<CommunityEmails> communityEmail(@RequestParam("city") String city) {
	return new ResponseEntity<>(service.communityEmail(city),HttpStatus.OK);
    }
    
    @GetMapping("fire")
    public ResponseEntity<FireView> fire(@RequestParam("address") String address) {
	return new ResponseEntity<>(service.fire(address), HttpStatus.OK);
    }
    
    @GetMapping("flood/stations")
    public ResponseEntity<List<FloodView>> flood(@RequestParam("stations") String stations) {
	return new ResponseEntity<>(service.flood(stations), HttpStatus.OK);
    }
}
