package co.simplon.gael.dtos;

import java.util.List;

public record PersonInfoView(
	String firstName,
	String lastName,
	String address,
	String mail,
	int age,
	List<String> allergies,
	List<String> medications
	) {

}
