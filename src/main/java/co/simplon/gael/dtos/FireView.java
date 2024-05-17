package co.simplon.gael.dtos;

import java.util.List;

public record FireView(
	List<PersonView> persons,
	String firestationNumber
	) {

}
