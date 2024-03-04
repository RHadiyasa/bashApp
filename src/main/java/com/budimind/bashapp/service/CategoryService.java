package com.budimind.bashapp.service;

import com.budimind.bashapp.dto.request.CreateCategoryRequest;
import com.budimind.bashapp.dto.response.CategoryResponse;
import com.budimind.bashapp.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findCategoryById(String id);
    List<Category> findAllCategory();
    CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);
    Category editCategory(Category category);
    void deleteCategoryById(String id);
}
