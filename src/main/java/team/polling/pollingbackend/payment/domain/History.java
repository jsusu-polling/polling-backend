package team.polling.pollingbackend.payment.domain;

import team.polling.pollingbackend.payment.domain.constants.Type;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class History {

    private Long id;
    private Payment payment;
    private Integer money;
    private String content;

    @Enumerated(EnumType.STRING)
    private Type type;

}
