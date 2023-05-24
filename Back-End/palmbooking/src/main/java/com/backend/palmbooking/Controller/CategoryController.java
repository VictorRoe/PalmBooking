package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Exception.GlobalExcepction;
import com.backend.palmbooking.Model.Category;
import com.backend.palmbooking.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Category> getCategoryByID(@PathVariable Long id) throws GlobalExcepction {
        Category category = categoryService.getCategoryByID(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(category);
        }
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping
    public ResponseEntity<Category> editCategory(@RequestBody Category category) throws GlobalExcepction {
        Category searchCategory = categoryService.getCategoryByID(category.getId());
        if (searchCategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.editCategory(category));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryByID(@PathVariable Long id) throws GlobalExcepction {
        Category searchCategory = categoryService.getCategoryByID(id);
        if (searchCategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        categoryService.deleteCategoryByID(id);
        return ResponseEntity.noContent().build();
    }

//    GET Category by category_id(product's table)

    @GetMapping("/{id_category}/product")
    public List<Category> findByCategoryID(@PathVariable("id_category") Long id) {
        return categoryService.findProductByCategoryID(id);
    }




}
