package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Model.Category;
import com.backend.palmbooking.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class CategoryController {


    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryByID(@PathVariable Long id) {
        return categoryService.getCategoryByID(id);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping
    public Category editCategory(@RequestBody Category category) {
        return categoryService.editCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryByID(@PathVariable Long id) {
        categoryService.deleteCategoryByID(id);
    }


}
