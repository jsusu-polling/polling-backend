package team.polling.pollingbackend.participation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.polling.pollingbackend.participation.repository.AnswerRepository;
import team.polling.pollingbackend.participation.repository.ParticipationRepository;
import team.polling.pollingbackend.survey.repository.QuestionRepository;
import team.polling.pollingbackend.survey.repository.SurveyRepository;

@Service
@RequiredArgsConstructor
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    private final AnswerRepository answerRepository;
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;



}
