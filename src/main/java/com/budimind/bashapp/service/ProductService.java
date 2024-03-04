package com.budimind.bashapp.service;

import com.budimind.bashapp.entity.Product;

import java.util.List;

public interface ProductService {

    Product findProductById(String id);
    Product createProduct(Product product);

    Product editProduct(Product product);

    Product editProductImage(String id, String image);

    List<Product> findAllProduct();
    void deleteProduct(String id);
}
