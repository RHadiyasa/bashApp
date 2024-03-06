package com.budimind.bashapp.controller;

import com.budimind.bashapp.dto.request.CreateProductRequest;
import com.budimind.bashapp.dto.request.SearchProductRequest;
import com.budimind.bashapp.dto.request.UpdateProductRequest;
import com.budimind.bashapp.dto.response.ProductResponse;
import com.budimind.bashapp.dto.response.WebResponse;
import com.budimind.bashapp.entity.Product;
import com.budimind.bashapp.exception.ResourceNotFoundException;
import com.budimind.bashapp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

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

    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<Product>> findAllProducts(){
        List<Product> products = productService.findAllProduct();
        return WebResponse.<List<Product>>builder().data(products).build();
    }

    @GetMapping(path = "/products/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<ProductResponse> get(@RequestParam(value = "productId", required = false) String productId){
        ProductResponse productResponse = productService.findProductById(productId);
        return WebResponse.<ProductResponse>builder().data(productResponse).build();
    }

    @PutMapping(path = "/products/detail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<ProductResponse> update(@RequestParam(value = "productId") String productId,
                                               @RequestBody UpdateProductRequest updateProductRequest){
        updateProductRequest.setId(productId);
        try {
            ProductResponse productResponse = productService.editProduct(updateProductRequest);
            return WebResponse.<ProductResponse>builder().data(productResponse).build();
        } catch (ResourceNotFoundException e) {
            return WebResponse.<ProductResponse>builder().errors(e.getMessage()).build();
        }
    }

    @DeleteMapping("/products/{productId}")
    public WebResponse<String> deleteProduct(@PathVariable("productId") String productId){
        productService.deleteProduct(productId);
        return WebResponse.<String>builder().data("OK").build();
    }

}
