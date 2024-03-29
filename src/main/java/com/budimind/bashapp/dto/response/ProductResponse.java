package com.budimind.bashapp.dto.response;


import com.budimind.bashapp.dto.request.CreateCategoryRequest;
import com.budimind.bashapp.entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.NamedAttributeNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.datasource.init.CannotReadScriptException;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String name;
    private Double price;
    private String description;
    private String image;

    @JsonIgnore
    private String categoryId;
    private String categoryName;
}
