package com.quiz.Service;

import com.quiz.entity.quiz.Category;
import com.quiz.entity.quiz.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {
    Quiz addQuiz(Quiz quiz);

    Quiz UpdateQuiz(Quiz quiz);

    Set<Quiz> getQuizzes();

    Quiz getQuiz(Long quizId);


    void deleteQuiz(Long quizId);


    public List<Quiz> GetQuizesOfCategory(Category category);

    public List<Quiz> getActiveQuizzes();

    public List<Quiz> getActiveQuizzesOfCategory(Category c);



}

