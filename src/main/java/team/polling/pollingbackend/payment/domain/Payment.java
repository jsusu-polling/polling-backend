package team.polling.pollingbackend.payment.domain;

import team.polling.pollingbackend.user.domain.User;

import java.util.ArrayList;

public class Payment {

    private Long id;
    private User user;
    private ArrayList<History> histories;

}
