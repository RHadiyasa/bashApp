package com.budimind.bashapp.controller;

import com.budimind.bashapp.dto.request.CreateCategoryRequest;
import com.budimind.bashapp.dto.response.CategoryResponse;
import com.budimind.bashapp.dto.response.WebResponse;
import com.budimind.bashapp.entity.Category;
import com.budimind.bashapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/categories",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> findAllCategory() {
        return categoryService.findAllCategory();
    }

    @GetMapping(path = "/categories/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Category findCategoryById(@PathVariable("id") String id) {
        return categoryService.findCategoryById(id);
    }

    @PostMapping(path = "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<CategoryResponse> createCategory(@RequestBody CreateCategoryRequest createCategoryRequest) {
        CategoryResponse categoryResponse = categoryService.createCategory(createCategoryRequest);
        return WebResponse.<CategoryResponse>builder().data(categoryResponse).build();
    }

    @PutMapping(path = "/categories",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Category editCategory(@RequestBody Category category) {
        return categoryService.editCategory(category);
    }

    @DeleteMapping(path = "/categories/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> deleteCategoryById(@PathVariable("id") String id) {
        categoryService.deleteCategoryById(id);
        return WebResponse.<String>builder().data("OK").build();
    }

}
