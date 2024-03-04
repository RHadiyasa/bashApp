package com.budimind.bashapp.controller;

import com.budimind.bashapp.dto.request.CreateCategoryRequest;
import com.budimind.bashapp.dto.request.CreateProductRequest;
import com.budimind.bashapp.dto.request.SearchProductRequest;
import com.budimind.bashapp.dto.response.ProductResponse;
import com.budimind.bashapp.dto.response.WebResponse;
import com.budimind.bashapp.entity.Product;
import com.budimind.bashapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<ProductResponse> createProduct(@RequestBody CreateProductRequest createCategoryRequest) {
        ProductResponse productResponse = productService.createProduct(createCategoryRequest);

        return WebResponse.<ProductResponse>builder().data(productResponse).build();
    }

}
