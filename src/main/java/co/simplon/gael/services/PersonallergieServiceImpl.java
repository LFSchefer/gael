package co.simplon.gael.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.gael.entities.PersonAllergie;
import co.simplon.gael.repositories.PersonAllergieRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonallergieServiceImpl implements PersonAllergieService {
    
    private final PersonAllergieRepository repository;
    
    public List<PersonAllergie> findAll() {
	return repository.findAll();
    }

}
