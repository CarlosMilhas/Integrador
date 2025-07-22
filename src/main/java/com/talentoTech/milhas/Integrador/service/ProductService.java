package com.talentoTech.milhas.Integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.talentoTech.milhas.Integrador.dto.ProductDto;
import com.talentoTech.milhas.Integrador.exceptions.NoStockException;
import com.talentoTech.milhas.Integrador.model.Product;
import com.talentoTech.milhas.Integrador.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository myRepository;

    public Product saveProduct(Product product) {
        return myRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return myRepository.findAll();
    }

    public Product updateProduct(ProductDto productDTO, long id) throws NoStockException {
        Optional<Product> optionalProduct = myRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            if (productDTO.getName() != null) {
                existingProduct.setName(productDTO.getName());
            }

            if (productDTO.getPrice() != null && productDTO.getPrice() > 0) {
                existingProduct.setPrice(productDTO.getPrice());
            }
            if (productDTO.getStock() != null && productDTO.getStock() >= 0) {
                existingProduct.setStock(productDTO.getStock());
            }

            return myRepository.save(existingProduct);
        }
        return null;
    }

    public boolean deleteProduct(long id) {
        if (myRepository.existsById(id)) {
            myRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Product findById(long id) {
        return myRepository.findById(id).orElse(null);
    }

    public List<Product> findByName(String name) {
        if (myRepository.findByName(name) != null) {
            return myRepository.findByName(name);
        }
        return null;

    }
}
