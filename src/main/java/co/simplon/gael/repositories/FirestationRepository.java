package co.simplon.gael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.simplon.gael.entities.Firestation;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation, String>{
    
    String FIND_FIRESTATION = "SELECT * FROM firestations f "
    	+ "WHERE f.address = (:address)";
    
    @Query(value = FIND_FIRESTATION, nativeQuery = true)
    Firestation toto(@Param("address") String address);
    
}
