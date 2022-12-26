package com.example.spring_restapi_session.repo;

import com.example.spring_restapi_session.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}