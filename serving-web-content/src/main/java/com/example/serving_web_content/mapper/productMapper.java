package com.example.serving_web_content.mapper;


import com.example.serving_web_content.dto.ProductDto;
import com.example.serving_web_content.entity.Product;

public class productMapper {
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getCost(),
                product.getQuantity()

        );
    }
    public static Product mapToProduct(ProductDto ProductDto){
        return new Product(
                ProductDto.getId(),
                ProductDto.getProductName(),
                ProductDto.getCost(),
                ProductDto.getQuantity()
        );

    }
}
