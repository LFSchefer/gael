package co.simplon.gael.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gael.services.ComplexService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping()
@AllArgsConstructor
public class AlertController {

    ComplexService service;
    
    @GetMapping("/childAlert")
    public void childAlert(@RequestParam("address") String input) {
	service.childAlert(input);
    }
}
