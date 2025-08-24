package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
                .filter(c -> c.getCategoryId()
                        .equals(categoryId)).findFirst()
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
//        if (category == null) {
//            return "Category not found";
//        }
         categories.remove(category);
        return "category with categoryId : " + categoryId + " deleted Successfully";
    }

//    @Override
//    public Optional<Object> findById(Long id) {
//        return Optional.empty();
//    }

    @Override
    public Category getCategoryById(Long id) {
        for (Category c : categories) {
            if (c.getCategoryId().equals(id)) {
                return c; // found
            }
        }
        return null; // not found
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> OptionalCategory = categories.stream()
                .filter(c -> c.getCategoryId()
                        .equals(categoryId)).findFirst();
        if (OptionalCategory.isPresent()) {
            Category categoryToUpdate = OptionalCategory.get();
            categoryToUpdate.setCategoryName(category.getCategoryName());
            return categoryToUpdate;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found");
        }
    }
//@Override
//public String deleteCategory(Long categoryId) {
//    boolean removed = categories.removeIf(
//            c -> java.util.Objects.equals(c.getCategoryId(), categoryId)
//    );
//    return removed
//            ? "Category with categoryId: " + categoryId + " deleted successfully"
//            : "Category not found";
//}

}
