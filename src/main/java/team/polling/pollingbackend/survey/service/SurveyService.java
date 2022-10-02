package team.polling.pollingbackend.survey.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.polling.pollingbackend.survey.domain.Survey;
import team.polling.pollingbackend.survey.repository.SurveyRepository;
import team.polling.pollingbackend.user.domain.User;
import team.polling.pollingbackend.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;

    public List<Survey> getAllSurveyListByUser(String email) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        List<Survey> surveys = surveyRepository.findAllByUser(user);
        return surveys;
    }

}
