package com.budimind.bashapp.service;

import com.budimind.bashapp.dto.request.CreateProductRequest;
import com.budimind.bashapp.dto.response.ProductResponse;
import com.budimind.bashapp.entity.Product;

import java.util.List;

public interface ProductService {

    Product findProductById(String id);
    ProductResponse createProduct(CreateProductRequest createProductRequest);
    Product editProduct(Product product);

    Product editProductImage(String id, String image);

    List<Product> findAllProduct();
    void deleteProduct(String id);
}
