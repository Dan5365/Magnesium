package com.example.serving_web_content.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "cost",nullable = false)
    private int cost;
    @Column(name = "quantity", nullable = false)
    private int quantity;
}
