package co.simplon.gael.dots;

import jakarta.validation.constraints.NotBlank;

public record PersonCreate(
	@NotBlank String firstname,
	@NotBlank String lastname,
	@NotBlank String address,
	@NotBlank String city,
	@NotBlank String zip,
	@NotBlank String phone,
	@NotBlank String email
	) {
}
