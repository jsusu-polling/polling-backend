package team.polling.pollingbackend.survey.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.polling.pollingbackend.participation.domain.Participation;
import team.polling.pollingbackend.participation.repository.ParticipationRepository;
import team.polling.pollingbackend.survey.domain.Survey;
import team.polling.pollingbackend.common.constants.Category;
import team.polling.pollingbackend.survey.domain.constants.Status;
import team.polling.pollingbackend.survey.repository.SurveyRepository;
import team.polling.pollingbackend.user.domain.User;
import team.polling.pollingbackend.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;
    private final ParticipationRepository participationRepository;

    public List<Survey> getAllSurveyListByUser(String email) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        List<Survey> surveys = surveyRepository.findAllByUser(user);
        return surveys;
    }

    public List<Survey> getAllParticipationSurveyByUser(String email) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        List<Participation> participations = participationRepository.findAllByUserOrderByCreatedDateDesc(user);
        return participations.stream().map(Participation::getSurvey).collect(Collectors.toList());
    }

    @Transactional
    public Long createSurvey(String email) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        Survey survey = Survey.builder().user(user).status(Status.PENDING).build();
        return surveyRepository.save(survey).getId();
    }

    @Transactional
    public void updateSurveyTitle(Long id, String title) {
        Survey survey = surveyRepository.findById(id).orElse(null);
        survey.setTitle(title);
        surveyRepository.save(survey);
    }

    @Transactional
    public void updateSurveyCategory(Long id, String category){
        Survey survey = surveyRepository.findById(id).orElse(null);
        survey.setCategory(Category.valueOf(category).toString());
        surveyRepository.save(survey);
    }

    @Transactional
    public void updateSurveyExplanation(Long id, String explanation){
        Survey survey = surveyRepository.findById(id).orElse(null);
        survey.setExplanation(explanation);
        surveyRepository.save(survey);
    }



}
