package co.simplon.gael.services;

import static java.time.temporal.ChronoUnit.YEARS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.gael.dtos.ChildAlertView;
import co.simplon.gael.entities.MedicalRecord;
import co.simplon.gael.entities.Person;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ComplexServiceImpl implements ComplexService {

    private final PersonsService personService;
    private final MedicalRecordService medicalRecordService;
    
    public List<ChildAlertView> childAlert(String input) {
	//Find persons by address
	List<Person> persons = personService.findPersons().stream().filter(t -> t.getAddress().equals(input)).toList();
	//find medical records for persons
	List<MedicalRecord> medicalRecords = medicalRecordService.findAll()
		.stream()
		.filter(m -> persons.stream()
			.map(Person::getFirstname)
			.toList()
			.contains(m.getFirstname())
		&&
		persons.stream()
			.map(Person::getLastname)
			.toList()
			.contains(m.getLastname()))
			.toList();	
	
	//Check if there are some minor
	final var minorsMedicalRecords = medicalRecords.stream().map(m -> {
	    if (isMinor(calculateAge(m))) {
		return m;
	    }
	    return null;
	}).filter(t -> t != null).toList();
	//or else return []
	if (minorsMedicalRecords.isEmpty()) {
	    return List.of();
	}
	
	
	List<Person> minors = persons
		.stream()
		.filter(p -> minorsMedicalRecords.stream().map(MedicalRecord::getFirstname).toList().contains(p.getFirstname()) && minorsMedicalRecords.stream().map(MedicalRecord::getLastname).toList().contains(p.getLastname()))
		.toList();
	
//	System.out.println(minors);
	
	 List<String> test = minors.stream().filter(m -> 
	 	minorsMedicalRecords.stream().map(MedicalRecord::getFirstname).toList().contains(m.getFirstname()) 
	 	&& 
	 	minorsMedicalRecords.stream().map(MedicalRecord::getLastname).toList().contains(m.getLastname()))
		 .map(t -> t.getFirstname())
		 .toList();

//	System.out.println(test);
	
	List<Integer> ages = minorsMedicalRecords.stream().map(t -> { return calculateAge(t);}).toList();
	
	System.out.println(ages);
	
	
	System.out.println(calculateAge(minorsMedicalRecords.stream().filter(t -> (t.getFirstname().equals("Roger"))).findFirst().get()));
	
	List<ChildAlertView> childAlert = new ArrayList<>();
	childAlert = minors.stream().map(minor -> {
	    return new ChildAlertView(
		minor.getFirstname(),
		minor.getLastname()
		
		)
		;} ).toList();
	
	System.out.println(childAlert);
	
	return minors.stream()
	.map(minor -> {
	    return new ChildAlertView();
	}).toList();
	
    }


    private int calculateAge(MedicalRecord m) {
	final LocalDate dateNow = LocalDate.now();
	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	return (int) YEARS.between(LocalDate.parse(m.getBirthdate() , formatter), dateNow);
    }
    
    
    private boolean isMinor(final int number) {
	return number < 18;
    }
}
