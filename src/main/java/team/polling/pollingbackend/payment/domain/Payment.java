package team.polling.pollingbackend.payment.domain;

import lombok.*;
import team.polling.pollingbackend.common.domain.BaseTime;
import team.polling.pollingbackend.payment.domain.constants.Type;
import team.polling.pollingbackend.user.domain.User;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Payment extends BaseTime {

    @Id @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    private Integer money;
    private String content;

    @Enumerated(EnumType.STRING)
    private Type type;

}
