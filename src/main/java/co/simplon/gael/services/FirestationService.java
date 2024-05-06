package co.simplon.gael.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.gael.dtos.FirestationCreate;
import co.simplon.gael.dtos.FirestationUpdate;
import co.simplon.gael.entities.Firestation;
import co.simplon.gael.repositories.FirestationRepository;

@Service
public class FirestationService {
    
    FirestationRepository repository;
    
    public FirestationService(FirestationRepository repository) {
	this.repository = repository;
    }
    
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
    
}
