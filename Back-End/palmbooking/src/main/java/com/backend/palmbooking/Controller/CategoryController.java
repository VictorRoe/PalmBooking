package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Model.Category;
import com.backend.palmbooking.Model.Product;
import com.backend.palmbooking.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> editCategory(@RequestBody Category category) {
        Optional<Category> buscarCategoria = categoryService.getCategoryByID(category.getId());

        if (buscarCategoria.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        categoryService.editCategory(category);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryByID(@PathVariable Long id) {
        Optional<Category> buscarCategoria = categoryService.getCategoryByID(id);

        if (buscarCategoria.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteCategoryByID(id);
        return ResponseEntity.status(204).build();
    }

//    GET Category by category_id(product's table)

    @GetMapping("/{id_category}/product")
    public List<Category> findByCategoryID(@PathVariable("id_category") Long id) {
        return categoryService.findProductByCategoryID(id);
    }




}
