package team.polling.pollingbackend.participation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.polling.pollingbackend.participation.domain.Participation;
import team.polling.pollingbackend.user.domain.User;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    List<Participation> findAllByUserOrderByCreatedDateDesc(User user);

}
