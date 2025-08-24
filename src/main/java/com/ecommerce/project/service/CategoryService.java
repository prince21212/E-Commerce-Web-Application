package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);

//    Optional<Object> findById(Long id);

    Category getCategoryById(Long id);
    Category updateCategory(Category category, Long categoryId);
}
