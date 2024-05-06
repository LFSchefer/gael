package co.simplon.gael.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.gael.dtos.PersonMedication;
import co.simplon.gael.entities.MedicalRecord;
import co.simplon.gael.repositories.MedicationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {
    
    private final MedicationRepository repository;

    public List<MedicalRecord> findAll() {
	return repository.findAll();
    }
    
    public PersonMedication findMedication(String firstname) {
	PersonMedication personmedication = new PersonMedication();
	personmedication.setMedication(repository.findMedication(firstname));
	return personmedication;
	
    }
}
