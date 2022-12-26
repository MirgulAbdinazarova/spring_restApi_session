package com.example.spring_restapi_session.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class LoginResponse {

    private  String jwtToken;
    private String message;
    private Set<String> authorities;
}
