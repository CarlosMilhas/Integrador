package com.talentoTech.milhas.Integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentoTech.milhas.Integrador.model.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

}
