package team.polling.pollingbackend.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.polling.pollingbackend.payment.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

}
