package team.polling.pollingbackend.survey.domain;

import lombok.*;
import team.polling.pollingbackend.common.domain.BaseTime;
import team.polling.pollingbackend.survey.domain.constants.Category;
import team.polling.pollingbackend.survey.domain.constants.Condition;

import javax.persistence.*;

@Entity(name = "question")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Question extends BaseTime {

    @Id @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Survey survey;

    private String question;
    private String answer;

    @Enumerated(EnumType.STRING)
    private Category category;
    
    @Enumerated(EnumType.STRING)
    private Condition condition;
}
