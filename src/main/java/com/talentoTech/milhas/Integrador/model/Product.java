package com.todocodeacademy.milhas.Integrador.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String imageUrl;
    private int stock;
}
