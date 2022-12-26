package com.example.spring_restapi_session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterResponse {

    private String id;
    private String email;
    private String firstName;
}
