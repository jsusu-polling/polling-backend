package team.polling.pollingbackend.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.polling.pollingbackend.survey.domain.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
