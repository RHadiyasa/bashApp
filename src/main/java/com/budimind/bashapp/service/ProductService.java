package com.budimind.bashapp.service;

import com.budimind.bashapp.dto.request.CreateProductRequest;
import com.budimind.bashapp.dto.request.UpdateProductRequest;
import com.budimind.bashapp.dto.response.ProductResponse;
import com.budimind.bashapp.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponse findProductById(String id);
    ProductResponse createProduct(CreateProductRequest createProductRequest);
    ProductResponse editProduct(UpdateProductRequest updateProductRequest);

    Product editProductImage(String id, String image);

    List<Product> findAllProduct();
    void deleteProduct(String id);
}
