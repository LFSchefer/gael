package co.simplon.gael.dtos;

import java.util.List;

import lombok.Data;
@Data
public class FindFirestationPersonsView {

	private List<FirestationPerson> persons;
	private int majorPersons;
	private int minorPersons;
}
