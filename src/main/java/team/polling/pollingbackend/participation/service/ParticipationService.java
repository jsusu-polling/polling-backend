package team.polling.pollingbackend.participation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.polling.pollingbackend.participation.domain.Answer;
import team.polling.pollingbackend.participation.domain.Participation;
import team.polling.pollingbackend.participation.repository.AnswerRepository;
import team.polling.pollingbackend.participation.repository.ParticipationRepository;
import team.polling.pollingbackend.survey.domain.Question;
import team.polling.pollingbackend.survey.domain.Survey;
import team.polling.pollingbackend.survey.repository.QuestionRepository;
import team.polling.pollingbackend.survey.repository.SurveyRepository;
import team.polling.pollingbackend.user.domain.User;
import team.polling.pollingbackend.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    private final AnswerRepository answerRepository;
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createParticipation(String email, Long surveyId) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        Survey survey = surveyRepository.findById(surveyId).orElse(null);
        participationRepository.save(Participation.builder().user(user).survey(survey).build());
    }

    @Transactional
    public void makeAnswer(String email, Long surveyId, Long questionId, String result) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        Survey survey = surveyRepository.findById(surveyId).orElse(null);
        Participation participation = participationRepository.findByUserAndSurvey(user, survey);
        Question question = questionRepository.findById(questionId).orElse(null);

        Answer answer = answerRepository.findAnswerByParticipationAndAndQuestion(participation, question).orElse(Answer.builder().participation(participation).question(question).build());
        answer.setResult(result);
        answerRepository.save(answer);
    }

}
