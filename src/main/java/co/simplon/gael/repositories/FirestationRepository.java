package co.simplon.gael.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.simplon.gael.dtos.FindFirestationPerson;
import co.simplon.gael.entities.Firestation;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation, String>{
    
    String FIND_FIRESTATION = "SELECT * FROM firestations f "
    	+ "WHERE f.address = (:address)";
    
    @Query(value = FIND_FIRESTATION, nativeQuery = true)
    Firestation toto(@Param("address") String address);

    
    String FIND_FIRESTATION_PERSONS = "SELECT p.firstname as firstname, p.lastname as lastname, p.address as address, p.phone as phone,m.birthdate as birthdate FROM firestations f"
    	+ " JOIN persons p ON p.address = f.address"
    	+ " JOIN medicalrecords m ON m.firstname = p.firstname AND m.lastname = p.lastname "
    	+ " WHERE f.station = :stationNumber";

    @Query(value= FIND_FIRESTATION_PERSONS, nativeQuery = true)
    List<FindFirestationPerson> findFirestationPersons(@Param("stationNumber") String stationNumber);
}
