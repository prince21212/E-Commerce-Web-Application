package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    //    private List<Category> categories = new ArrayList<>();
    private final CategoryRepository categoryRepository;
    private Long nextId = 1L;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {

//        category.setCategoryId(nextId++);
//        categories.add(category);

        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

/*
        Category category = categories.stream()
                .filter(c -> c.getCategoryId()
                        .equals(categoryId)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        if (category == null) {
            return "Category not found";
        }
         categories.remove(category);
 */

        categoryRepository.delete(category);
        return "category with categoryId : " + categoryId + " deleted Successfully";
    }

/*
    @Override
    public Optional<Object> findById(Long id) {
        return Optional.empty();
    }
*/

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

/*
        for (Category c : categories) {
            if (c.getCategoryId().equals(id)) {
                return categoryRepository.findById(category); // found
            }
        }
        return null; // not found

 */
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
//        List<Category> categories = categoryRepository.findAll();
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;

/*
        Optional<Category> OptionalCategory = categories.stream()
                .filter(c -> c.getCategoryId()
                        .equals(categoryId)).findFirst();

        if (OptionalCategory.isPresent()) {
            Category categoryToUpdate = OptionalCategory.get();
            categoryToUpdate.setCategoryName(category.getCategoryName());
            Category savedCategory = categoryRepository.save(categoryToUpdate);
            return savedCategory;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found");
        }
*/

    }

}
