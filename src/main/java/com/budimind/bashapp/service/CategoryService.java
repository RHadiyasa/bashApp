package com.budimind.bashapp.service;

import com.budimind.bashapp.dto.request.CreateCategoryRequest;
import com.budimind.bashapp.dto.response.CategoryResponse;
import com.budimind.bashapp.entity.Category;
import com.budimind.bashapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

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

    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest){
        Category category = new Category();
        category.setId(UUID.randomUUID().toString());
        category.setCategoryName(createCategoryRequest.getCategoryName());
        categoryRepository.save(category);

        return CategoryResponse.builder().id(category.getId()).categoryName(category.getCategoryName()).build();
    }

    public Category editCategory(Category category){
        return categoryRepository.save(category); // Same with create function
    }

    public void deleteCategoryById(String id){
        Category category = categoryRepository.findById(id)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found!"));

        categoryRepository.delete(category); // This function is void because delete is not return anything.
    }
}

