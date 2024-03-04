package com.budimind.bashapp.dto.response;


import com.budimind.bashapp.entity.Category;
import jakarta.persistence.NamedAttributeNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String name;
    private BigInteger price;
    private String description;
    private String image;
    private CategoryResponse categoryResponse;
}
