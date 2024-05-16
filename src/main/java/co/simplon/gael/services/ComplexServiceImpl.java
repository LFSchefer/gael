package co.simplon.gael.services;

import static java.time.temporal.ChronoUnit.YEARS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.gael.dtos.ChildAlertView;
import co.simplon.gael.dtos.CommunityEmails;
import co.simplon.gael.dtos.FireView;
import co.simplon.gael.dtos.PersonFireView;
import co.simplon.gael.dtos.PhoneAlertView;
import co.simplon.gael.entities.Firestation;
import co.simplon.gael.entities.MedicalRecord;
import co.simplon.gael.entities.Person;
import co.simplon.gael.entities.PersonAllergie;
import co.simplon.gael.entities.PersonMedication;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ComplexServiceImpl implements ComplexService {

    private final PersonsService personService;
    private final MedicalRecordService medicalRecordService;
    private final FirestationService firestationService;
    private final PersonAllergieService personAllergieService;
    private final PersonMedicationService personMedicationService;
    
    public List<ChildAlertView> childAlert(String input) {
	//Find persons by address
	List<Person> persons = personService.findAll().stream().filter(t -> t.getAddress().equals(input)).toList();
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
	
	List<ChildAlertView> childAlert = new ArrayList<>();
	childAlert = minors.stream().map(minor -> {
	    return new ChildAlertView(
		minor.getFirstname(),
		minor.getLastname(),
		calculateAge(minorsMedicalRecords.stream().filter(t -> (t.getFirstname().equals(minor.getFirstname()) && t.getLastname().equals(minor.getLastname()))).findFirst().get()),
		persons.stream().filter(t -> !(t.getFirstname().equals(minor.getFirstname()) && t.getLastname().equals(minor.getLastname())) ).map( person -> { 
		    return new ChildAlertView.PersonIdentity(
			    person.getFirstname(),
			    person.getLastname());
			    }).toList()
		)
		;} ).toList();
	
	System.out.println(childAlert);

	return childAlert;
    }

    
    public PhoneAlertView phoneAlert(String firestationNumber) {
	List<Firestation> firestations = firestationService.findAll().stream().filter(f -> f.getStation().equals(firestationNumber) ).toList();
	List<Person> persons = personService.findAll().stream().filter(p -> firestations.stream()
		.map(Firestation::getAddress)
		.toList()
		.contains(p.getAddress())
		)
		.toList();
	return new PhoneAlertView(persons.stream().map(p -> p.getPhone()).toList());
    }
    
    
    public  CommunityEmails communityEmail(String city) {
	return new CommunityEmails( personService.findAll().stream().filter(t -> t.getCity().equals(city)).map(p -> p.getEmail()).toList()  );
    }
    
    public FireView fire(String address) {
	List<Person> persons = personService.findAll().stream().filter(t -> t.getAddress().equals(address)).toList();
	Firestation firestation = firestationService.findAll().stream().filter(f -> f.getAddress().equals(persons.get(0).getAddress())).findFirst().get();
	List<MedicalRecord> medicalRecords = medicalRecordService.findAll().stream().filter(m -> (persons.stream()
		.map(Person::getFirstname).toList().contains(m.getFirstname())
			&&
			persons.stream()
		.map(Person::getLastname).toList().contains(m.getLastname())
		)).toList();
	List<PersonAllergie> personAllergies = personAllergieService.findAll().stream().filter(a -> 
		(persons.stream().map(Person::getFirstname).toList().contains(a.getFirstname())
		&&
		persons.stream().map(Person::getLastname).toList().contains(a.getLastname()))
		).toList();
	List<PersonMedication> personMedications = personMedicationService.findAll().stream().filter(m ->
		(persons.stream().map(Person::getFirstname).toList().contains(m.getFirstname())
		&&
		persons.stream().map(Person::getLastname).toList().contains(m.getLastname()))
		).toList();
	List<PersonFireView> personsFireView = new ArrayList<>();
	personsFireView = persons.stream().map(person -> {return new PersonFireView(
		person.getFirstname(),
		person.getLastname(),
		person.getPhone(),
		calculateAge(medicalRecords.stream().filter(m -> m.getFirstname().equals(person.getFirstname()) && m.getLastname().equals(person.getLastname())).findFirst().get()),
		personAllergies.stream().filter(a -> a.getFirstname().equals(person.getFirstname()) && a.getLastname().equals(person.getLastname()) ).map(a -> a.getAllergieName() ).toList() ,
		personMedications.stream().filter(a -> a.getFirstname().equals(person.getFirstname()) && a.getLastname().equals(person.getLastname()) ).map(t -> t.getMedicationName() ).toList() 
		);}
	).toList();

	return new FireView(personsFireView,firestation.getStation());
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
