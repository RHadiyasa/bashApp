package com.budimind.bashapp.service;

import com.budimind.bashapp.entity.Product;
import com.budimind.bashapp.exception.ResourceNotFoundException;
import com.budimind.bashapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(String id){
        return productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product with " + id + " is not found!"));
    }

    public Product createProduct(Product product){
        product.setImage(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    public Product editProduct(Product product){
        return productRepository.save(product);
    }

    public Product editProductImage(String id, String image){
        Product product = findProductById(id);
        product.setImage(image);
        return productRepository.save(product);
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }
}
