package com.budimind.bashapp.controller;

import com.budimind.bashapp.dto.request.CreateProductRequest;
import com.budimind.bashapp.dto.response.ProductResponse;
import com.budimind.bashapp.dto.response.WebResponse;
import com.budimind.bashapp.entity.Product;
import com.budimind.bashapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<ProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        ProductResponse productResponse = productService.createProduct(createProductRequest);
        return WebResponse.<ProductResponse>builder().data(productResponse).build();
    }

}
