package team.polling.pollingbackend.survey.domain;

import team.polling.pollingbackend.survey.domain.constants.Category;
import team.polling.pollingbackend.survey.domain.constants.Condition;

public class Question {

    private Long id;
    private String question;
    private String answer;
    private Category category;
    private Condition condition;
}
