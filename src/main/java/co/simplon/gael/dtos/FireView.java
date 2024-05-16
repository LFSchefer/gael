package co.simplon.gael.dtos;

import java.util.List;

public record FireView(
	List<PersonFireView> persons,
	String firestationNumber
	) {

}
