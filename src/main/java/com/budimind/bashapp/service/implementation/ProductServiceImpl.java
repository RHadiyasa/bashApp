package com.budimind.bashapp.service.implementation;

import com.budimind.bashapp.dto.request.CreateProductRequest;
import com.budimind.bashapp.dto.response.ProductResponse;
import com.budimind.bashapp.entity.Product;
import com.budimind.bashapp.exception.ResourceNotFoundException;
import com.budimind.bashapp.repository.ProductRepository;
import com.budimind.bashapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with " + id + " is not found!"));
    }
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        createProductRequest.setImage(UUID.randomUUID().toString());
        return null;
    }

    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    public Product editProductImage(String id, String image) {
        Product product = findProductById(id);
        product.setImage(image);
        return productRepository.save(product);
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    private ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .image(product.getImage())
                .build();
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
