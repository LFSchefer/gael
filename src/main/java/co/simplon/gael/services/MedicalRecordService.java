package co.simplon.gael.services;

import java.util.List;

import co.simplon.gael.dtos.CreateMedicalRecord;
import co.simplon.gael.dtos.PersonAllergies;
import co.simplon.gael.dtos.PersonMedicalRecord;
import co.simplon.gael.dtos.PersonMedications;
import co.simplon.gael.entities.MedicalRecord;

public interface MedicalRecordService {

    List<MedicalRecord> findAll();

    PersonMedications findMedication(String firstname);

    PersonAllergies findAllergies(String firstname);

    PersonMedicalRecord findMedicalRecord(String firstname);

    void deleteRecord(String firstname);

    CreateMedicalRecord createMedicalRecord(CreateMedicalRecord input);
}
