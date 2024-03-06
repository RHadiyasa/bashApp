package com.budimind.bashapp.dto.request;

import com.budimind.bashapp.entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.security.auth.message.callback.PrivateKeyCallback;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.sqm.produce.function.StandardFunctionReturnTypeResolvers;
import org.springframework.context.annotation.Primary;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductRequest {

    @NotBlank
    @Size(max = 255)
    private String name;
    private Double price;
    @Size(max = 255)
    private String description;
    @Size(max = 255)
    private String image;

    private String categoryName;
}
