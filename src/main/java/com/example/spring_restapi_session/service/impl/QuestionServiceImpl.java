package com.example.spring_restapi_session.service.impl;

import com.example.spring_restapi_session.converter.QuestionRequestConverter;
import com.example.spring_restapi_session.converter.QuestionResponseConverter;
import com.example.spring_restapi_session.dto.QuestionRequest;
import com.example.spring_restapi_session.dto.QuestionResponse;
import com.example.spring_restapi_session.entity.Question;
import com.example.spring_restapi_session.repo.QuestionRepository;
import com.example.spring_restapi_session.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private  final QuestionRepository questionRepository;
    private final QuestionRequestConverter questionRequestConverter;
    private final QuestionResponseConverter questionResponseConverter;

    @Override
    public QuestionResponse saveQuestion(QuestionRequest questionRequest) {
        Question question = questionRequestConverter.create(questionRequest);
        questionRepository.save(question);
        return questionResponseConverter.viewQuestion(question);
    }

    @Override
    public List<QuestionResponse> findAllQuestion() {
        return questionResponseConverter.view(questionRepository.findAll());
    }

    @Override
    public QuestionResponse findById(Long id) {
       Question question = questionRepository.findById(id).get();
        return questionResponseConverter.viewQuestion(question);
    }

    @Override
    public QuestionResponse deleteByIdQuestion(Long id) {
        Question question = questionRepository.findById(id).get();
        questionRepository.delete(question);
        return questionResponseConverter.viewQuestion(question);
    }

    @Override
    public QuestionResponse updateQuestion(Long id, QuestionRequest questionRequest) {
        Question question = questionRepository.findById(id).get();
        questionRequestConverter.update(question,questionRequest);

        return questionResponseConverter.viewQuestion(questionRepository.save(question));
    }
}
