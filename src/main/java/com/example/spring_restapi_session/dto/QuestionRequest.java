package com.example.spring_restapi_session.dto;

import com.example.spring_restapi_session.entity.Option;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class QuestionRequest {

    private String name;
    private String text;
    private int duration;
    private int numberOfRespondents;
    private List<Option> options;
}
