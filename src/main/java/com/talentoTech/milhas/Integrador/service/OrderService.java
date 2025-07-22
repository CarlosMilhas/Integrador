package com.talentoTech.milhas.Integrador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentoTech.milhas.Integrador.dto.OrderCreateDto;
import com.talentoTech.milhas.Integrador.dto.OrderDto;
import com.talentoTech.milhas.Integrador.repository.IOrderRepository;

import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final IOrderRepository orderRepository;

    public Order createOrder(OrderDto order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    public OrderDto createOrder(OrderCreateDto orderCreateDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    public List<OrderDto> findAllOrders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllOrders'");
    }

    public OrderDto findOrderById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOrderById'");
    }

    public boolean deleteById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
