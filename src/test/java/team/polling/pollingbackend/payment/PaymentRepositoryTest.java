package team.polling.pollingbackend.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import team.polling.pollingbackend.payment.repository.PaymentRepository;
import team.polling.pollingbackend.payment.repository.PointRepository;

@DataJpaTest
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PointRepository pointRepository;

    @Test
    void 보상_정보_생성_및_업데이트() {

    }

    @Test
    void 사용자_포인트_조회() {

    }

    @Test
    void 사용자_포인트_업데이트() {

    }

}
