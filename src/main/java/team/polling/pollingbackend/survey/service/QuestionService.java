package team.polling.pollingbackend.survey.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.polling.pollingbackend.survey.domain.Question;
import team.polling.pollingbackend.survey.domain.Selection;
import team.polling.pollingbackend.survey.domain.Survey;
import team.polling.pollingbackend.survey.domain.constants.Template;
import team.polling.pollingbackend.survey.repository.QuestionRepository;
import team.polling.pollingbackend.survey.repository.SelectionRepository;
import team.polling.pollingbackend.survey.repository.SurveyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SelectionRepository selectionRepository;
    private final SurveyRepository surveyRepository;

    @Transactional
    public Question createShortQuestion(Long surveyId, String title) {
        Survey survey = surveyRepository.findById(surveyId).orElse(null);
        Question question = Question.builder().survey(survey).question(title).template(Template.SHORT).build();
        return questionRepository.save(question);
    }

    @Transactional
    public Question createLongQuestion(Long surveyId, String title) {
        Survey survey = surveyRepository.findById(surveyId).orElse(null);
        Question question = Question.builder().survey(survey).question(title).template(Template.LONG).build();
        return questionRepository.save(question);
    }

    @Transactional
    public Question createMonoQuestion(Long surveyId, String title, List<String> selections) {
        Survey survey = surveyRepository.findById(surveyId).orElse(null);
        Question question = questionRepository.save(Question.builder().survey(survey).question(title).template(Template.MONOSELECT).build());
        List<Selection> selectionList = selections.stream().map(selection -> Selection.builder().question(question).selection(selection).build()).toList();
        selectionRepository.saveAll(selectionList);
        return question;
    }

    @Transactional
    public Question createMulticQuestion(Long surveyId, String title, List<String> selections) {
        Survey survey = surveyRepository.findById(surveyId).orElse(null);
        Question question = questionRepository.save(Question.builder().survey(survey).question(title).template(Template.MULTISELECT).build());
        List<Selection> selectionList = selections.stream().map(selection -> Selection.builder().question(question).selection(selection).build()).toList();
        selectionRepository.saveAll(selectionList);
        return question;
    }
}
