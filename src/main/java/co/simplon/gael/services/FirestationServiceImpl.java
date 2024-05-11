package co.simplon.gael.services;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import static java.time.temporal.ChronoUnit.YEARS;

import org.springframework.stereotype.Service;

import co.simplon.gael.dtos.FindFirestationPerson;
import co.simplon.gael.dtos.FindFirestationPersonsView;
import co.simplon.gael.dtos.FirestationCreate;
import co.simplon.gael.dtos.FirestationUpdate;
import co.simplon.gael.dtos.FirestationPerson;
import co.simplon.gael.entities.Firestation;
import co.simplon.gael.repositories.FirestationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FirestationServiceImpl implements FirestationService{
    
    private final FirestationRepository repository;
    
    public List<Firestation> findAll() {
	return repository.findAll();
    }

    public Firestation create(FirestationCreate input) {
	Firestation firestation = new Firestation();
	firestation.setAddress(input.address());
	firestation.setStation(input.station());
	return repository.saveAndFlush(firestation);
    }
    
    public Firestation update(FirestationUpdate input) {
	if (repository.existsById(input.address())) {
	    Firestation firestation = repository.findById(input.address()).get();
	    firestation.setStation(input.station());
	    return repository.saveAndFlush(firestation);
	}
	else {
	    return null;
	}
    }

    public void delete(String id) {
	repository.deleteById(id);
    }
    
    public Firestation toto(String address) {
	return repository.toto(address);
    }
    
//    public Firestation toto(String id) {
//	return repository.findById(id).get();
//    }
    
    public FindFirestationPersonsView findFirestationPersons(String stationNumber) throws ParseException {
	List<FindFirestationPerson> findFirestationPersons = repository.findFirestationPersons(stationNumber);
	List<FirestationPerson> firestationPersons = new ArrayList<>();
	FindFirestationPersonsView findFirestationPersonsView = new FindFirestationPersonsView();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate dateNow = LocalDate.now();
	for (FindFirestationPerson findFirestationPerson : findFirestationPersons) {
	    FirestationPerson person = new FirestationPerson(
		    findFirestationPerson.getFirstname(),
		    findFirestationPerson.getLastname(),
		    findFirestationPerson.getAddress(),
		    findFirestationPerson.getPhone());
	    firestationPersons.add(person);
	    LocalDate date = LocalDate.parse(findFirestationPerson.getBirthdate(), formatter);
	    long diff = YEARS.between(date, dateNow);
	    if (diff >=  18) {findFirestationPersonsView.setMajorPersons(findFirestationPersonsView.getMajorPersons()+1);}
	    else {findFirestationPersonsView.setMinorPersons(findFirestationPersonsView.getMinorPersons()+1);}
	}
	findFirestationPersonsView.setPersons(firestationPersons);
	return findFirestationPersonsView;
    }

}
