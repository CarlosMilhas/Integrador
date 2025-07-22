package com.talentoTech.milhas.Integrador.model;

import com.talentoTech.milhas.Integrador.exceptions.NoStockException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double price;

    private int stock;

    public void setStock(int stock) throws NoStockException {
        if (stock < 0) {
            throw new NoStockException("Stock insuficiente");
        }
        this.stock = stock;
    }
}
