package com.talentoTech.milhas.Integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDto {
    private Long id;
    private Long productId; 
    private String productName; 
    private double productPrice; 
    private int quantity;
    private double subtotal; 
}
