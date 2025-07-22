package com.talentoTech.milhas.Integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentoTech.milhas.Integrador.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

}