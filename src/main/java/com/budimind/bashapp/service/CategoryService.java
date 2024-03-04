package com.budimind.bashapp.service;

import com.budimind.bashapp.entity.Category;
import com.budimind.bashapp.repository.CategoryRepository;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findCategoryById(String id){
        return categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category with " + id + " is not found"));
    }

    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category editCategory(Category category){
        return categoryRepository.save(category); // Same with create function
    }

    public void deleteCategoryById(String id){
        categoryRepository.deleteById(id); // This function is void because delete is not return anything.
    }
}

