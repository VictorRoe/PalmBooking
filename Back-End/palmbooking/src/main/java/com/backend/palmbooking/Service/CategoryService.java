package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.ProductNotFoundExcepction;
import com.backend.palmbooking.Model.Category;
import com.backend.palmbooking.Model.Product;
import com.backend.palmbooking.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Category getCategoryByID(Long id) throws ProductNotFoundExcepction {
        Optional<Category> searchCategories = categoryRepository.findById(id);
        if (searchCategories.isPresent()){
            return searchCategories.get();
        } else {
            throw new ProductNotFoundExcepction("ID NOT FOUND");
        }
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category editCategory(Category category) throws ProductNotFoundExcepction {
        Optional<Category> editCategory = categoryRepository.findById(category.getId());
        if (editCategory.isPresent()) {
            return categoryRepository.save(category);
        } else {
            throw new ProductNotFoundExcepction("ID NOT FOUND");
        }

    }

    public void deleteCategoryByID(Long id) throws ProductNotFoundExcepction {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new ProductNotFoundExcepction("ID NOT FOUND");
        }
    }

//    GET Product by category ID
    public List<Category> findProductByCategoryID(Long id){
        return categoryRepository.findProductByCategoryID(id);
    }


}
