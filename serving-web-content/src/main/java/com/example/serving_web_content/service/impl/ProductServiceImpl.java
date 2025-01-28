package com.example.serving_web_content.service.impl;

import com.example.serving_web_content.dto.ProductDto;
import com.example.serving_web_content.entity.Product;
import com.example.serving_web_content.exception.ResourceNotFoundException;
import com.example.serving_web_content.mapper.productMapper;
import com.example.serving_web_content.repository.ProductRepository;
import com.example.serving_web_content.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product is not exists with given id:"+ productId));
        return productMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map((product)-> productMapper.mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long ProductId, ProductDto updatedProduct) {
        Product product = productRepository.findById(ProductId).orElseThrow(
                ()-> new ResourceNotFoundException("Product is not exists with given id:"+ ProductId)
        );

        product.setProductName(updatedProduct.getProductName());
        product.setCost(updatedProduct.getCost());
        product.setQuantity(updatedProduct.getQuantity());
        Product updatedProductObj = productRepository.save(product);
        return productMapper.mapToProductDto(updatedProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("Product is not exists with given id:"+ productId)
        );
        productRepository.deleteById(productId);
    }
}
