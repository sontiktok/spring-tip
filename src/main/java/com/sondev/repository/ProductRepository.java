package com.sondev.repository;

import com.sondev.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    ProductEntity createProduct(ProductEntity product);
    List<ProductEntity> findAllProducts();
}
