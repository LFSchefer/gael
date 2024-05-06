package co.simplon.gael.dtos;

import jakarta.validation.constraints.NotBlank;

public record FirestationUpdate(
	String address,
	@NotBlank String station
	) {

}
