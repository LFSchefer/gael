package co.simplon.gael.dtos;

public record PersonUpdate(
	String firstname,
	String lastname,
	String address,
	String city,
	String zip,
	String phone,
	String email
	) {

}
