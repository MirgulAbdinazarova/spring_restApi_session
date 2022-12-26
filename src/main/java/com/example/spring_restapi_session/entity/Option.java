package com.example.spring_restapi_session.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="options")
@Getter
@Setter
@NoArgsConstructor
public class Option {

    @Id
    @SequenceGenerator(name="option_gen",sequenceName = "option_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "option_gen")
    private Long id;
    private String name;
    private String file;
    private boolean isCorrect=false;

}
