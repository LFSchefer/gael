package co.simplon.gael.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.gael.dtos.CreateMedicalRecord;
import co.simplon.gael.dtos.PersonAllergies;
import co.simplon.gael.dtos.PersonMedicalRecord;
import co.simplon.gael.dtos.PersonMedications;
import co.simplon.gael.entities.Allergie;
import co.simplon.gael.entities.MedicalRecord;
import co.simplon.gael.entities.Medication;
import co.simplon.gael.entities.PersonAllergie;
import co.simplon.gael.entities.PersonMedication;
import co.simplon.gael.repositories.AllergieRepository;
import co.simplon.gael.repositories.MedicationRecordRepository;
import co.simplon.gael.repositories.MedicationRepository;
import co.simplon.gael.repositories.PersonAllergieRepository;
import co.simplon.gael.repositories.PersonMedicationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {
    
    private final MedicationRecordRepository repository;
    private final PersonMedicationRepository personMedicationRepository;
    private final PersonAllergieRepository personAllergieRepository;
    private final MedicationRepository medicationRepository;
    private final AllergieRepository allergieRepository;

    public List<MedicalRecord> findAll() {
	return repository.findAll();
    }
    
    public PersonMedications findMedication(String firstname) {
	try {
		PersonMedications personmedication = new PersonMedications();
		personmedication.setMedication(repository.findMedication(firstname));
		return personmedication;
	} catch (Exception e) {
	    System.out.println(e);
	    return null;
	}

    }
    
    public PersonAllergies findAllergies(String firstname) {
	try {
		PersonAllergies personallergies = new PersonAllergies();
		personallergies.setAllergies(repository.findAllergies(firstname));
		return personallergies;
	} catch (Exception e) {
	    System.out.println(e);
	    return null;
	}

    }
    
    public PersonMedicalRecord findMedicalRecord(String firstname) {
	try {
		PersonMedicalRecord personmedicalrecord = new PersonMedicalRecord();
		personmedicalrecord.setMedications(findMedication(firstname).getMedication());
		personmedicalrecord.setAllergies(findAllergies(firstname).getAllergies());
		MedicalRecord medicalrecord = repository.findById(firstname).get();
		personmedicalrecord.setFirstname(medicalrecord.getFirstname());
		personmedicalrecord.setLastname(medicalrecord.getLastname());
		personmedicalrecord.setBirthday(medicalrecord.getBirthdate());
		System.out.println(personmedicalrecord);
		return personmedicalrecord;
	} catch (Exception e) {
	    System.out.println(e);
	    return null;
	}

    }
    
    public void deleteRecord(String firstname) {
	repository.deleteById(firstname);
    }
    
    public CreateMedicalRecord createMedicalRecord(CreateMedicalRecord input) {
	CreateMedicalRecord medicalRecordCreation = new CreateMedicalRecord(
		input.firstname(),
		input.lastname(),
		input.birthday(),
		input.medications(),
		input.allergies());
//	System.out.println(medicalRecordCreation);
	
	MedicalRecord newMedicalRecord = new MedicalRecord();
	newMedicalRecord.setFirstname(medicalRecordCreation.firstname());
	newMedicalRecord.setLastname(medicalRecordCreation.lastname());
	newMedicalRecord.setBirthdate(medicalRecordCreation.birthday());
//	System.out.println(newMedicalRecord);
	repository.save(newMedicalRecord);
	
	List<Medication> medicationList = new ArrayList<>(medicationRepository.findAll());
	for (int i = 0; i < medicalRecordCreation.medications().size(); i++) {
	    if (!medicationList.contains(medicalRecordCreation.medications().get(i))) {
		Medication medication = new Medication();
		medication.setMedication_name(medicalRecordCreation.medications().get(i));
		medicationRepository.save(medication);
	    }
	    
	    PersonMedication personmedication = new PersonMedication();
	    personmedication.setFirstname(medicalRecordCreation.firstname());
	    personmedication.setLastname(medicalRecordCreation.lastname());
	    personmedication.setMedicationName(medicalRecordCreation.medications().get(i));
	    personMedicationRepository.save(personmedication);
	}
	
	List<Allergie> allergieList = new ArrayList<>(allergieRepository.findAll());
	for (int i = 0; i < medicalRecordCreation.allergies().size(); i++) {
	    if (!allergieList.contains(medicalRecordCreation.allergies().get(i))) {
		Allergie allergie = new Allergie();
		allergie.setAllergies_name(medicalRecordCreation.allergies().get(i));
		allergieRepository.save(allergie);
	    }
	    
	    PersonAllergie personallergie = new PersonAllergie();
	    personallergie.setFirstname(medicalRecordCreation.firstname());
	    personallergie.setLastname(medicalRecordCreation.lastname());
	    personallergie.setAllergieName(medicalRecordCreation.allergies().get(i));
//	    System.out.println(personallergie);
	    personAllergieRepository.save(personallergie);
	}
	return medicalRecordCreation;
    }
	
}
