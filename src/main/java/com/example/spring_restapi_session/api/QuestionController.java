package com.example.spring_restapi_session.api;

import com.example.spring_restapi_session.dto.QuestionRequest;
import com.example.spring_restapi_session.dto.QuestionResponse;
import com.example.spring_restapi_session.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestionController {

    private final QuestionService questionService;
    @PostMapping("/save")
    public QuestionResponse save(@RequestBody QuestionRequest questionRequest) {
        return  questionService.saveQuestion(questionRequest);
    }
    @GetMapping("/all")
    public List<QuestionResponse> findAll() {
        return questionService.findAllQuestion();
    }
    @GetMapping("/{id}")
    public  QuestionResponse findById(@PathVariable Long id) {
        return questionService.findById(id);
    }
    @DeleteMapping("/{id}")
    public QuestionResponse deleteById(@PathVariable Long id) {
        return questionService.deleteByIdQuestion(id);
    }
    @PutMapping("/{id}")
    public  QuestionResponse update(@PathVariable Long id,
                                    @RequestBody QuestionRequest questionRequest) {
        return questionService.updateQuestion(id,questionRequest);
    }

}
