package com.budimind.bashapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private String image;

    @JoinColumn
    @ManyToOne
    private Category category;
    private BigDecimal price;
    private Integer stock;
}
