package team.polling.pollingbackend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.polling.pollingbackend.user.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByKakaoId(Long kakaoId);
    User findUserById(Long id);
    Optional<User> findUserByEmail(String email);
}
