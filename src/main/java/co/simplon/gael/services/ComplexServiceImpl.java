package co.simplon.gael.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.gael.entities.MedicalRecord;
import co.simplon.gael.entities.Person;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ComplexServiceImpl implements ComplexService {

    private final PersonsService personService;
    private final MedicalRecordService medicalRecordService;
    
    public void childAlert(String input) {
	List<Person> persons = personService.findPersons().stream().filter(t -> t.getAddress().equals(input)).toList();
	List<MedicalRecord> medicalRecords = medicalRecordService.findAll();
	List<MedicalRecord> filterMedicalRecord = new ArrayList<>();
	for (Person person : persons) {
	    medicalRecords.stream().filter(t -> t.getFirstname().equals(person.getFirstname()) && t.getLastname().equals(person.getLastname())).forEach(t -> filterMedicalRecord.add(t));
	}	
	System.out.println(persons);
	System.out.println(filterMedicalRecord);

    }
}
