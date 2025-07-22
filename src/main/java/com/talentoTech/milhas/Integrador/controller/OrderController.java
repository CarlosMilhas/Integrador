package com.talentoTech.milhas.Integrador.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentoTech.milhas.Integrador.dto.OrderCreateDto;
import com.talentoTech.milhas.Integrador.dto.OrderDto;
import com.talentoTech.milhas.Integrador.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService myService;

    @PostMapping()
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderCreateDto orderCreateDto) {
        OrderDto createdOrderDto = myService.createOrder(orderCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDto);
    }

    @GetMapping()
    public ResponseEntity<List<OrderDto>> findAllOrders() {
        List<OrderDto> orders = myService.findAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findOrderById(@PathVariable Long id) {
        OrderDto order = myService.findOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
        boolean deleted = myService.deleteById(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
