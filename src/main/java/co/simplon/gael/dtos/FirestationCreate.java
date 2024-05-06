package co.simplon.gael.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FirestationCreate(
	@Size(min=5)
	String address,
	@NotBlank
	String station
	) {

}
