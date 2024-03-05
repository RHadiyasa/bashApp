package com.budimind.bashapp.service.implementation;

import com.budimind.bashapp.dto.request.CreateProductRequest;
import com.budimind.bashapp.dto.response.ProductResponse;
import com.budimind.bashapp.entity.Category;
import com.budimind.bashapp.entity.Product;
import com.budimind.bashapp.exception.ResourceNotFoundException;
import com.budimind.bashapp.repository.CategoryRepository;
import com.budimind.bashapp.repository.ProductRepository;
import com.budimind.bashapp.service.ProductService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product findProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with " + id + " is not found!"));
    }

    public ProductResponse createProduct(CreateProductRequest createProductRequest)  {

        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(createProductRequest.getName());
        product.setPrice(createProductRequest.getPrice());
        product.setDescription(createProductRequest.getDescription());
        product.setImage(createProductRequest.getImage());

        Optional<Category> categoryOptional = categoryRepository.findById(createProductRequest.getCategoryId());

        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            product.setCategory(category);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID Product Not Found");
        }

        productRepository.save(product);

        return ProductResponse.builder().id(product.getId())
                .name(product.getName()).price(product.getPrice()).
                description(product.getDescription()).image(createProductRequest.getImage())
                .categoryId(createProductRequest.getCategoryId())
                .build();
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
