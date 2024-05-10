package co.simplon.gael.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.simplon.gael.entities.MedicalRecord;

@Repository
public interface MedicationRepository extends JpaRepository<MedicalRecord, String>{
    
    String FIND_PERSON_MEDICATION = "SELECT pm.medication_name FROM medicalrecords m "
    	+ "JOIN person_medication pm ON m.firstname = pm.firstname WHERE m.firstname = :firstname";
    
    @Query(value=FIND_PERSON_MEDICATION, nativeQuery = true)
    List<String> findMedication(@Param("firstname") String firstname);

    String FIND_PERSON_ALLERGIES = "SELECT pa.allergie_name FROM medicalrecords m "
    	+ "JOIN person_allergie pa ON m.firstname = pa.firstname WHERE m.firstname = :firstname";
    
    @Query(value=FIND_PERSON_ALLERGIES, nativeQuery = true)
    List<String> findAllergies(@Param("firstname") String firstname);
    
//    String INSERT_PERSON_MEDICATION = "INSERT INTO person_medication (firstname, lastname, medication_name) VALUES"
//    	+ "(:firstname,:lastname,:medication)";
//
//    @Query(value=INSERT_PERSON_MEDICATION, nativeQuery = true)
//    Object insertPersonMedication(@Param("medication") String medication,@Param("firstname") String firstname,@Param("lastname") String lastname);

}
