package team.polling.pollingbackend.participation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.polling.pollingbackend.participation.domain.Answer;
import team.polling.pollingbackend.participation.domain.Participation;
import team.polling.pollingbackend.survey.domain.Question;

import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Optional<Answer> findAnswerByParticipationAndAndQuestion(Participation participation, Question question);
}
