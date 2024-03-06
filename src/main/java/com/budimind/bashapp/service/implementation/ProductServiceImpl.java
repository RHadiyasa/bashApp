package com.budimind.bashapp.service.implementation;

import com.budimind.bashapp.dto.request.CreateProductRequest;
import com.budimind.bashapp.dto.request.UpdateProductRequest;
import com.budimind.bashapp.dto.response.ProductResponse;
import com.budimind.bashapp.entity.Category;
import com.budimind.bashapp.entity.Product;
import com.budimind.bashapp.exception.BadRequestException;
import com.budimind.bashapp.exception.ResourceNotFoundException;
import com.budimind.bashapp.repository.CategoryRepository;
import com.budimind.bashapp.repository.ProductRepository;
import com.budimind.bashapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
//        this.product = product;
    }

    @Transactional(readOnly = true)
    public ProductResponse findProductById(String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not Found"));
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName()).price(product.getPrice())
                .description(product.getDescription()).image(product.getImage())
                .categoryName(product.getCategory().getCategoryName())
                .categoryId(product.getCategory().getId())
                .build();
    }

    public ProductResponse createProduct(CreateProductRequest createProductRequest)  {

        if (!StringUtils.hasText(createProductRequest.getCategoryName())){
            throw new BadRequestException("Category name cannot be empty");
        }

        if (!StringUtils.hasText(createProductRequest.getName())){
            throw new BadRequestException("Product name cannot empty");
        }

        if (createProductRequest.getCategoryName() == null){
            throw new BadRequestException("Category cannot be empty");
        }

        if (productRepository.existsByName(createProductRequest.getName())){
            throw new BadRequestException("Cannot add same product");
        }

        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(createProductRequest.getName());
        product.setPrice(createProductRequest.getPrice());
        product.setDescription(createProductRequest.getDescription());
        product.setImage(createProductRequest.getImage());

        Optional<Category> categoryOptional = categoryRepository.findCategoryByCategoryNameIgnoreCase(createProductRequest.getCategoryName());

        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            product.setCategory(category);
        } else {
            throw new ResourceNotFoundException("Category Not Found");
        }

        String categoryName = categoryRepository.findCategoryByCategoryNameIgnoreCase(createProductRequest.getCategoryName())
                .map(Category::getCategoryName)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found!"));

        productRepository.save(product);

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .image(createProductRequest.getImage())
                .categoryName(categoryName)
                .build();
    }


    @Transactional
    public ProductResponse editProduct(UpdateProductRequest updateProductRequest) {

        Product product = productRepository.findById(updateProductRequest.getId())
                        .orElseThrow(()-> new ResourceNotFoundException("Product not found in database!"));

        product.setId(product.getId());
        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        product.setImage(updateProductRequest.getImage());
        product.setDescription(updateProductRequest.getDescription());

        Optional<Category> categoryOptional = categoryRepository.findCategoryByCategoryNameIgnoreCase(updateProductRequest.getCategoryName());
        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            product.setCategory(category);
        } else {
            throw new ResourceNotFoundException("ID Product Not Found");
        }

        String categoryName = categoryOptional.map(Category::getCategoryName)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found!"));

        ProductResponse productResponse = ProductResponse.builder().id(product.getId())
                .name(product.getName()).price(product.getPrice()).
                description(product.getDescription()).image(updateProductRequest.getImage())
                .categoryName(categoryName)
                .build();

        productRepository.save(product);

        return productResponse;
    }

    public Product editProductImage(String id, String image) {
        ProductResponse productResponse = findProductById(id);
        productResponse.setImage(image);
        return null;
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public void deleteProduct(String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        productRepository.deleteById(id);
    }

}