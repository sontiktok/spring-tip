package com.sondev.repository.impl;

import com.sondev.entity.ProductEntity;
import com.sondev.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return List.of();
    }
}
