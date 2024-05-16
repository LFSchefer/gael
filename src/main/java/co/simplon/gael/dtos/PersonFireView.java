package co.simplon.gael.dtos;

import java.util.List;


public record PersonFireView(
	String firstName,
	String lastName,
	String phone,
	int age,
	List<String> allergies,
	List<String> medications
	) {

}
