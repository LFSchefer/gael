package co.simplon.gael.services;

import java.util.List;

import co.simplon.gael.dtos.PersonMedication;
import co.simplon.gael.entities.MedicalRecord;

public interface MedicalRecordService {

    List<MedicalRecord> findAll();

    PersonMedication findMedication(String firstname);
}
