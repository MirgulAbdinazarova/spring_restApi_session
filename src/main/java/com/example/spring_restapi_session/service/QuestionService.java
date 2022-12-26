package com.example.spring_restapi_session.service;

import com.example.spring_restapi_session.dto.QuestionRequest;
import com.example.spring_restapi_session.dto.QuestionResponse;
import com.example.spring_restapi_session.entity.Question;

import java.util.List;

public interface QuestionService {

     QuestionResponse saveQuestion(QuestionRequest questionRequest);

     List<QuestionResponse> findAllQuestion();

     QuestionResponse findById(Long id);

     QuestionResponse deleteByIdQuestion(Long id);

     QuestionResponse updateQuestion(Long id,QuestionRequest questionRequest);
}
