package team.polling.pollingbackend.survey.domain;

import lombok.*;
import team.polling.pollingbackend.common.domain.BaseTime;
import team.polling.pollingbackend.survey.domain.constants.Template;

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

    @ManyToOne @Column(name = "survey_id")
    private Survey survey;
    private String question;

    @Enumerated(EnumType.STRING)
    private Template template;
}
