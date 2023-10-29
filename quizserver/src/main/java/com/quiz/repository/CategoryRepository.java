package com.quiz.repository;

import com.quiz.entity.Role;
import com.quiz.entity.quiz.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category,Long> {


}
