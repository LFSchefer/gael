package co.simplon.gael.services;

import java.util.List;

import co.simplon.gael.dtos.ChildAlertView;
import co.simplon.gael.dtos.PhoneAlertView;

public interface ComplexService {

    List<ChildAlertView> childAlert(String input);

    List<PhoneAlertView> phoneAlert(String firestationNumber);
}
