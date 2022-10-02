package team.polling.pollingbackend.survey.domain;

import lombok.*;
import team.polling.pollingbackend.common.domain.BaseTime;

import javax.persistence.*;

@Entity(name = "selection")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Selection extends BaseTime {

    @Id @Column(name = "selection_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @Column(name = "question_id")
    private Question question;
    private String selection;

}
