package team.polling.pollingbackend.survey.domain;

import team.polling.pollingbackend.survey.domain.constants.Category;
import team.polling.pollingbackend.survey.domain.constants.Condition;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Question {

    private Long id;
    private String question;
    private String answer;

    @Enumerated(EnumType.STRING)
    private Category category;
    
    @Enumerated(EnumType.STRING)
    private Condition condition;
}
