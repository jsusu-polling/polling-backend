package team.polling.pollingbackend.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import team.polling.pollingbackend.user.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void 사용자_생성() {

    }

    @Test
    void 사용자_이메일_조회() {

    }

    @Test
    void 사용자_탈퇴() {

    }

}
