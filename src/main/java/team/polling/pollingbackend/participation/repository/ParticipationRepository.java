package team.polling.pollingbackend.participation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.polling.pollingbackend.participation.domain.Participation;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
}
