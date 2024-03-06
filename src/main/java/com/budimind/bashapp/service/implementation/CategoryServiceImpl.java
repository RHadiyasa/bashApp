package com.budimind.bashapp.service.implementation;

import com.budimind.bashapp.dto.request.CreateCategoryRequest;
import com.budimind.bashapp.dto.response.CategoryResponse;
import com.budimind.bashapp.entity.Category;
import com.budimind.bashapp.exception.BadRequestException;
import com.budimind.bashapp.repository.CategoryRepository;
import com.budimind.bashapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
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

        if (!StringUtils.hasText(createCategoryRequest.getCategoryName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Category name cannot be empty");
        }

        if (categoryRepository.existsByCategoryNameIgnoreCase(createCategoryRequest.getCategoryName())){
            throw new BadRequestException("Category was exists");
        }

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

