package com.talentoTech.milhas.Integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id; 
    private String name;
    private Double price; 
    private Integer stock; 
}
