package team.polling.pollingbackend.participation.domain;

import lombok.*;
import team.polling.pollingbackend.survey.domain.Question;
import team.polling.pollingbackend.user.domain.User;

import javax.persistence.*;

@Entity(name = "answer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Answer {

    @Id @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Participation participation;

    @ManyToOne
    private Question question;
    private String result;

}
