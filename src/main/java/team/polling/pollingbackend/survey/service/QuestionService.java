package team.polling.pollingbackend.survey.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.polling.pollingbackend.survey.repository.QuestionRepository;
import team.polling.pollingbackend.survey.repository.SelectionRepository;
import team.polling.pollingbackend.survey.repository.SurveyRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SelectionRepository selectionRepository;
    private final SurveyRepository surveyRepository;


    
}
