package team.polling.pollingbackend.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.polling.pollingbackend.payment.domain.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
}
