package co.simplon.gael.services;

import java.util.List;

import co.simplon.gael.dtos.FirestationCreate;
import co.simplon.gael.dtos.FirestationUpdate;
import co.simplon.gael.entities.Firestation;

public interface FirestationService {

    List<Firestation> findAll();
    
    Firestation create(FirestationCreate input);
    
    Firestation update(FirestationUpdate input);
    
    void delete(String id);

    Firestation toto(String address);
    
}
