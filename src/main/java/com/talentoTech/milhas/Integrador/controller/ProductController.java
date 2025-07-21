package com.talentoTech.milhas.Integrador.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentoTech.milhas.Integrador.model.Product;
import com.talentoTech.milhas.Integrador.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService myService;

    @PostMapping()
    public void saveProduct(@RequestBody Product product) {
        myService.saveProduct(product);
    }

    @GetMapping()
    public List<Product> findAllProducts() {
        return myService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(long id) {
        return myService.findAllProducts().stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PutMapping()
    public void updateProduct(Product product, long id) {

        myService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(long id) {
        myService.deleteProduct(id);
    }

}
