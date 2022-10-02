package team.polling.pollingbackend.participation.domain;

import lombok.*;
import team.polling.pollingbackend.common.domain.BaseTime;
import team.polling.pollingbackend.survey.domain.Survey;
import team.polling.pollingbackend.user.domain.User;

import javax.persistence.*;

@Entity(name = "participation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Participation extends BaseTime {

    @Id @Column(name = "participation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Survey survey;
}
