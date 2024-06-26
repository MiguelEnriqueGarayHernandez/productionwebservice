package com.example.productionwebservice.controllers;

import com.example.productionwebservice.dto.ProductDTO;
import com.example.productionwebservice.entities.Product;
import com.example.productionwebservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int productId) {
        Optional<Product> product = productService.getProductById(productId);
        return product.map(p -> ResponseEntity.ok(productService.convertToDto(p)))
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.create(productDTO);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int productId, @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = productService.update(productId, productDTO);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }
}
