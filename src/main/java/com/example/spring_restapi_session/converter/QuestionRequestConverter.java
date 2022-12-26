package com.example.spring_restapi_session.converter;

import com.example.spring_restapi_session.dto.QuestionRequest;
import com.example.spring_restapi_session.entity.Option;
import com.example.spring_restapi_session.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionRequestConverter {

    public Question create(QuestionRequest questionRequest) {
        if(questionRequest==null) {
            return null;
        }
        Question question=new Question();
        question.setName(questionRequest.getName());
        question.setText(questionRequest.getText());
        question.setDuration(questionRequest.getDuration());
        question.setNumberOfRespondents(question.getNumberOfRespondents());
        question.setOptions(questionRequest.getOptions());
        return  question;
    }

    public void update(Question question, QuestionRequest questionRequest) {
        question.setName(questionRequest.getName());
        question.setText(questionRequest.getText());
        question.setDuration(questionRequest.getDuration());
        question.setNumberOfRespondents(question.getNumberOfRespondents());
        List<Option> options = question.getOptions();
        List<Option>optionList = questionRequest.getOptions();
        for (Option o1:options) {
            for (Option o2:optionList) {
                o1.setName(o2.getName());
                o1.setFile(o2.getFile());
                o1.setCorrect(o2.isCorrect());
            }
        }
    }
}
