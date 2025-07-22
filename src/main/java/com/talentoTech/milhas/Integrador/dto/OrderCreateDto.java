package com.talentoTech.milhas.Integrador.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateDto {
    private List<OrderLineCreateDto> orderLines;
}
