package com.quiz.repository;

import com.quiz.entity.Role;
import com.quiz.entity.quiz.Questions;
import com.quiz.entity.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionsRepository extends JpaRepository<Questions,Long> {
    Set<Questions> findByQuiz(Quiz quiz);
}
