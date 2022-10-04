package team.polling.pollingbackend.survey;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import team.polling.pollingbackend.survey.repository.QuestionRepository;
import team.polling.pollingbackend.survey.repository.SelectionRepository;
import team.polling.pollingbackend.survey.repository.SurveyRepository;

@DataJpaTest
public class SurveyRepositoryTest {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SelectionRepository selectionRepository;

    @Test
    @Order(1)
    void 설문지_생성() {

    }

    @Test
    @Order(2)
    void 설문지_단답형_생성() {

    }

    @Test
    @Order(3)
    void 설문지_장문형_생성() {

    }

    @Test
    @Order(4)
    void 설문지_단답_옵션_생성() {

    }

    @Test
    @Order(5)
    void 설문지_장문_옵션_생성() {

    }

    @Test
    @Order(6)
    void 설문지_시작_마감_날짜_설정() {

    }

    @Test
    @Order(7)
    void 설문지_삭제() {

    }

}
