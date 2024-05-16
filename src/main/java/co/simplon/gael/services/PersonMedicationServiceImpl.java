package co.simplon.gael.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.gael.entities.PersonMedication;
import co.simplon.gael.repositories.PersonMedicationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonMedicationServiceImpl implements PersonMedicationService {
    
    private final PersonMedicationRepository repository;

    public List<PersonMedication> findAll() {
	return repository.findAll();
    }
}
