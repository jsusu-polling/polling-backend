package team.polling.pollingbackend.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.polling.pollingbackend.survey.domain.Survey;
import team.polling.pollingbackend.user.domain.User;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    List<Survey> findAllByUser(User user);

}
