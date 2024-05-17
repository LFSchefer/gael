package co.simplon.gael.dtos;

import java.util.List;

public record FloodView(
	String station,
	List<PersonView> persons
	) {

}
