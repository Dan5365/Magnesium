package com.example.serving_web_content.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private long id;


    @NotNull(message = "Product Category cannot be null")
    private String productCategory;

    @NotNull(message = "Product name cannot be null")
    @Size(min = 2, max = 100, message = "Product name should be between 2 and 100 characters")
    private String productName;

    @Min(value = 0, message = "Cost must be greater than or equal to 0")
    private int cost;

    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
    private int quantity;



}
