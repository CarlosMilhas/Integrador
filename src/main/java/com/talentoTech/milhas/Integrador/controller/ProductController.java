package com.talentoTech.milhas.Integrador.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Product findProductById(@PathVariable long id) {
        return myService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable long id) {

        myService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        myService.deleteProduct(id);
    }

}
