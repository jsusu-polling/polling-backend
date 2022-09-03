package team.polling.pollingbackend.survey.domain;

import team.polling.pollingbackend.survey.domain.constants.Status;
import team.polling.pollingbackend.user.domain.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;

public class Survey {

    private Long id;
    private User user;
    private ArrayList<Question> questions;

    @Enumerated(EnumType.STRING)
    private Status status;

}
