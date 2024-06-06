package com.example.productionwebservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productionwebservice.dto.ProductPhotoDTO;
import com.example.productionwebservice.services.ProductPhotoService;

@RestController
@RequestMapping(path = "/productphotos")
public class ProductPhotoController {
    @Autowired
    private ProductPhotoService productPhotoService;

    @GetMapping
    public List<ProductPhotoDTO> getAllProductPhotos() {
        return productPhotoService.getAll();
    }

    @GetMapping("/{productPhotoId}")
    public ResponseEntity<ProductPhotoDTO> getProductPhotoById(@PathVariable int productPhotoId) {
        ProductPhotoDTO productPhoto = productPhotoService.getProductPhotoById(productPhotoId);
        return productPhoto != null ? ResponseEntity.ok(productPhoto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductPhotoDTO> createProductPhoto(@RequestBody ProductPhotoDTO productPhotoDTO) {
        ProductPhotoDTO createdProductPhoto = productPhotoService.create(productPhotoDTO);
        return ResponseEntity.ok(createdProductPhoto);
    }

    @PutMapping("/{productPhotoId}")
    public ResponseEntity<ProductPhotoDTO> updateProductPhoto(@PathVariable int productPhotoId, @RequestBody ProductPhotoDTO productPhotoDTO) {
        ProductPhotoDTO updatedProductPhoto = productPhotoService.update(productPhotoId, productPhotoDTO);
        return updatedProductPhoto != null ? ResponseEntity.ok(updatedProductPhoto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productPhotoId}")
    public ResponseEntity<Void> deleteProductPhoto(@PathVariable int productPhotoId) {
        productPhotoService.delete(productPhotoId);
        return ResponseEntity.noContent().build();
    }
}
