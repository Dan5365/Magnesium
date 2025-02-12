package com.example.serving_web_content.service;

import com.example.serving_web_content.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);
    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long ProductId, ProductDto updatedProduct);

    void deleteProduct(Long productId);

    List<ProductDto> getProductsByCategory(String category);

}
