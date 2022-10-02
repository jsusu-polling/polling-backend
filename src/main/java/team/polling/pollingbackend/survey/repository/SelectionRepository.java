package team.polling.pollingbackend.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.polling.pollingbackend.survey.domain.Selection;

@Repository
public interface SelectionRepository extends JpaRepository<Selection, Long> {
}
