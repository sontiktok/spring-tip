package com.sondev.entity;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "java_product_001")
public class ProductEntity {
    private Long id;
    private String productName;
    private String productPrice;
}
