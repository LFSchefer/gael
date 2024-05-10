package co.simplon.gael.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.gael.dtos.PersonAllergies;
import co.simplon.gael.dtos.PersonMedicalRecord;
import co.simplon.gael.dtos.PersonMedications;
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
    
    public PersonMedications findMedication(String firstname) {
	PersonMedications personmedication = new PersonMedications();
	personmedication.setMedication(repository.findMedication(firstname));
	return personmedication;
    }
    
    public PersonAllergies findAllergies(String firstname) {
	PersonAllergies personallergies = new PersonAllergies();
	personallergies.setAllergies(repository.findAllergies(firstname));
	return personallergies;
    }
    
    public PersonMedicalRecord findMedicalRecord(String firstname) {
	PersonMedicalRecord personmedicalrecord = new PersonMedicalRecord();
	personmedicalrecord.setMedications(findMedication(firstname).getMedication());
	personmedicalrecord.setAllergies(findAllergies(firstname).getAllergies());
	MedicalRecord medicalrecord = repository.findById(firstname).get();
	personmedicalrecord.setFirstname(medicalrecord.getFirstname());
	personmedicalrecord.setLastname(medicalrecord.getLastname());
	personmedicalrecord.setBirthday(medicalrecord.getBirthdate());
	System.out.println(personmedicalrecord);
	return personmedicalrecord;
    }
    
    public void deleteRecord(String firstname) {
	repository.deleteRecord(firstname);
    }
}
