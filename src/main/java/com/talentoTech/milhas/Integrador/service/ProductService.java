package com.talentoTech.milhas.Integrador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentoTech.milhas.Integrador.model.Product;
import com.talentoTech.milhas.Integrador.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository myRepository;

    public void saveProduct(Product product) {
        myRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return myRepository.findAll();
    }

}
