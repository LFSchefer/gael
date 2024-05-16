package co.simplon.gael.services;

import java.util.List;

import co.simplon.gael.dtos.ChildAlertView;
import co.simplon.gael.dtos.CommunityEmails;
import co.simplon.gael.dtos.FireView;
import co.simplon.gael.dtos.PersonFireView;
import co.simplon.gael.dtos.PhoneAlertView;

public interface ComplexService {

    List<ChildAlertView> childAlert(String input);

    PhoneAlertView phoneAlert(String firestationNumber);

    CommunityEmails communityEmail(String city);

    FireView fire(String address);
}
