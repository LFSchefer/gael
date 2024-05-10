package co.simplon.gael.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record CreateMedicalRecord(
	     @NotBlank String firstname,
	     @NotBlank String lastname,
	     @NotBlank String birthday,
	     List<String> medications,
	     List<String> allergies
	) {

}
