package team.polling.pollingbackend.survey.domain;

import lombok.*;
import team.polling.pollingbackend.common.domain.BaseTime;
import team.polling.pollingbackend.survey.domain.constants.Status;
import team.polling.pollingbackend.user.domain.User;

import javax.persistence.*;

@Entity(name = "survey")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Survey extends BaseTime {

    @Id @Column(name = "survey_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;

}
