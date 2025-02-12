package com.example.serving_web_content.mapper;


import com.example.serving_web_content.dto.ProductDto;
import com.example.serving_web_content.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        if (product == null) {
            return null;
        }
        return new ProductDto(
                product.getId(),
                product.getProductCategory(),
                product.getProductName(),
                product.getCost(),
                product.getQuantity()


        );
    }
    public static Product mapToProduct(ProductDto ProductDto){
        if (ProductDto == null) {
            return null;
        }
        return new Product(
                ProductDto.getId(),
                ProductDto.getProductCategory(),
                ProductDto.getProductName(),
                ProductDto.getCost(),
                ProductDto.getQuantity()
        );

    }
}
