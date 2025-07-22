package com.talentoTech.milhas.Integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineCreateDto {
    private Long productId;
    private int quantity; 
}
