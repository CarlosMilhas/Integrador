package com.talentoTech.milhas.Integrador.service;

import java.util.List;
import java.util.Optional;

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

    public void updateProduct(Product product, long id) {

        Optional<Product> optionalProduct = myRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setCategory(product.getCategory());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setImageUrl(product.getImageUrl());
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStock(product.getStock());
            myRepository.save(existingProduct);
        }

    }

    public void deleteProduct(long id) {
        myRepository.deleteById(id);
    }

    public Product findById(long id) {
        return myRepository.findById(id).orElse(null);
    }

}
