package team.polling.pollingbackend.participation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import team.polling.pollingbackend.participation.repository.AnswerRepository;
import team.polling.pollingbackend.participation.repository.ParticipationRepository;

@DataJpaTest
public class ParticipationRepositoryTest {

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @BeforeEach
    void 설문조사_참여하기() {

    }

    @Test
    void 참여한_설문조사_전체_조회() {

    }

    @Test
    void 참여한_특정_설문조사_조회() {

    }

    @Test
    void 참여한_설문조사_내_특정_질문_조회() {

    }
    
}
