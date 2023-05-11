package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.Category;
import com.backend.palmbooking.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryByID(Long id) {
        return categoryRepository.findById(id);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category editCategory(Category category) {
        Optional<Category> editCategory = categoryRepository.findById(category.getId());

        if (editCategory.isPresent()) {
            return categoryRepository.save(category);
        } else {
            System.out.println("No se encontro una id para editar");
        }
        return category;
    }

    public void deleteCategoryByID(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
        }
    }


}
