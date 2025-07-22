package com.talentoTech.milhas.Integrador.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentoTech.milhas.Integrador.dto.ProductDto;
import com.talentoTech.milhas.Integrador.exceptions.NoStockException;
import com.talentoTech.milhas.Integrador.model.Product;
import com.talentoTech.milhas.Integrador.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService myService;

    @PostMapping()
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) throws NoStockException {
        // Convert DTO to Entity for service layer
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        Product savedProduct = myService.saveProduct(product);
        ProductDto responseDTO = new ProductDto(savedProduct.getId(), savedProduct.getName(),
                savedProduct.getPrice(), savedProduct.getStock());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        List<Product> products = myService.findAllProducts();
        List<ProductDto> productDTOs = products.stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice(), p.getStock()))
                .toList();
        return ResponseEntity.ok(productDTOs);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable long id) {
        Product product = myService.findById(id);
        if (product != null) {
            ProductDto productDTO = new ProductDto(product.getId(), product.getName(), product.getPrice(),
                    product.getStock());
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProductDto>> findProductByName(@PathVariable String name) {
        List<Product> products = myService.findByName(name);
        if (products != null) {
            List<ProductDto> productDTOs = products.stream()
                    .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice(), p.getStock()))
                    .toList();
            return ResponseEntity.ok(productDTOs);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDTO, @PathVariable long id)
            throws NoStockException {
        Product updatedProduct = myService.updateProduct(productDTO, id);
        if (updatedProduct != null) {
            ProductDto updatedProductDTO = new ProductDto(updatedProduct.getId(), updatedProduct.getName(),
                    updatedProduct.getPrice(), updatedProduct.getStock());
            return ResponseEntity.ok(updatedProductDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        boolean deleted = myService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
