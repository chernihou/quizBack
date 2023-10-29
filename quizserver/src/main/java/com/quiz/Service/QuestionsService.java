package com.quiz.Service;

import com.quiz.entity.quiz.Questions;
import com.quiz.entity.quiz.Quiz;

import java.util.Set;

public interface QuestionsService {
    Questions addQuestion(Questions question);

    Questions UpdateQestion(Questions question);

    Set<Questions> getQuestions();

    Questions getQuestion(Long questionId);

   Set<Questions> getQuestionsOfQuiz(Quiz quiz);

    void deleteQuestion(Long questionId);
}
