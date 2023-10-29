package com.quiz.Service;

import com.quiz.entity.quiz.Category;

import java.util.Set;

public interface CategoryService {
    Category addCategory(Category category);

    Category UpdateCategory(Category category);

    Set<Category> getCategories();

    Category getCategory(Long categoryId);


    void deleteCategory(Long categoryId);
}
