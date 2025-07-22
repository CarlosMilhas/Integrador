package com.talentoTech.milhas.Integrador.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talentoTech.milhas.Integrador.dto.OrderCreateDto;
import com.talentoTech.milhas.Integrador.dto.OrderDto;
import com.talentoTech.milhas.Integrador.dto.OrderLineDto;
import com.talentoTech.milhas.Integrador.model.Order;
import com.talentoTech.milhas.Integrador.model.OrderLine;
import com.talentoTech.milhas.Integrador.model.Product;
import com.talentoTech.milhas.Integrador.repository.IOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final IOrderRepository orderRepository;
    private final ProductService productService;

    public OrderDto createOrder(OrderCreateDto orderCreateDto) {

        Order order = new Order();

        List<OrderLine> orderLines = orderCreateDto.getOrderLines().stream()
                .map(orderLineCreateDto -> {

                    Product product = productService.findById(orderLineCreateDto.getProductId());
                    if (product == null) {
                        throw new RuntimeException("Product not found with id: " + orderLineCreateDto.getProductId());
                    }

                    OrderLine orderLine = new OrderLine();
                    orderLine.setProduct(product);
                    orderLine.setQuantity(orderLineCreateDto.getQuantity());
                    orderLine.setOrder(order); // Establecer la relación
                    return orderLine;
                })
                .collect(Collectors.toList());

        order.setOrderLines(orderLines);

        Order savedOrder = orderRepository.save(order);

        return convertToDto(savedOrder);
    }

    public List<OrderDto> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public OrderDto findOrderById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        return order != null ? convertToDto(order) : null;
    }

    public boolean deleteById(long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private OrderDto convertToDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());

        List<OrderLineDto> orderLineDtos = order.getOrderLines().stream()
                .map(this::convertOrderLineToDto)
                .collect(Collectors.toList());
        dto.setOrderLines(orderLineDtos);

        return dto;
    }

    private OrderLineDto convertOrderLineToDto(OrderLine orderLine) {
        OrderLineDto dto = new OrderLineDto();
        dto.setId(orderLine.getId());
        dto.setProductId(orderLine.getProduct().getId());
        dto.setProductName(orderLine.getProduct().getName());
        dto.setProductPrice(orderLine.getProduct().getPrice());
        dto.setQuantity(orderLine.getQuantity());
        dto.setSubtotal(orderLine.getSubtotal());
        return dto;
    }

}
