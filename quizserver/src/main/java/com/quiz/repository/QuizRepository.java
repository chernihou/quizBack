package com.quiz.repository;

import com.quiz.entity.Role;
import com.quiz.entity.quiz.Category;
import com.quiz.entity.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    public List<Quiz> findByCategory(Category category);

    public List<Quiz> findByActive(Boolean b);

    public List<Quiz> findByCategoryAndActive(Category c,Boolean b);
}
