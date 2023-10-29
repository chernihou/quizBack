package com.quiz.Service.Impl;

import com.quiz.Service.QuestionsService;
import com.quiz.Service.QuizService;
import com.quiz.entity.quiz.Questions;
import com.quiz.entity.quiz.Quiz;
import com.quiz.repository.QuestionsRepository;
import com.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;


    @Override
    public Questions addQuestion(Questions question) {
        return this.questionsRepository.save(question);
    }

    @Override
    public Questions UpdateQestion(Questions question) {
        return this.questionsRepository.save(question);
    }

    @Override
    public Set<Questions> getQuestions() {
        return new HashSet<>(this.questionsRepository.findAll());
    }

    @Override
    public Questions getQuestion(Long questionId) {
        return this.questionsRepository.findById(questionId).get();
    }

    @Override
    public Set<Questions> getQuestionsOfQuiz(Quiz quiz) {
       return this.questionsRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Questions question=new Questions();
        question.setQuesid(questionId);
            this.questionsRepository.delete(question);

        }
    }


