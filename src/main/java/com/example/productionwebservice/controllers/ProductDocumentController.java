package com.example.productionwebservice.controllers;

import com.example.productionwebservice.dto.ProductDocumentDTO;
import com.example.productionwebservice.entities.ProductDocumentId;
import com.example.productionwebservice.services.ProductDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/productdocuments")
public class ProductDocumentController {

    @Autowired
    private ProductDocumentService productDocumentService;

    @GetMapping("")
    public List<ProductDocumentDTO> getAllProductDocuments() {
        return productDocumentService.getAll();
    }

    @GetMapping("/{productId}/{documentNode}")
    public ResponseEntity<ProductDocumentDTO> getProductDocumentById(@PathVariable int productId, @PathVariable String documentNode) {
        ProductDocumentId id = new ProductDocumentId(productId, documentNode);
        Optional<ProductDocumentDTO> productDocument = productDocumentService.getById(id);
        return productDocument.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<ProductDocumentDTO> createProductDocument(@RequestBody ProductDocumentDTO productDocumentDTO) {
        ProductDocumentDTO createdProductDocument = productDocumentService.create(productDocumentDTO);
        return ResponseEntity.ok(createdProductDocument);
    }

    @PutMapping("/{productId}/{documentNode}")
    public ResponseEntity<ProductDocumentDTO> updateProductDocument(@PathVariable int productId, @PathVariable String documentNode, @RequestBody ProductDocumentDTO productDocumentDTO) {
        ProductDocumentId id = new ProductDocumentId(productId, documentNode);
        ProductDocumentDTO updatedProductDocument = productDocumentService.update(id, productDocumentDTO);
        return updatedProductDocument != null ? ResponseEntity.ok(updatedProductDocument) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productId}/{documentNode}")
    public ResponseEntity<Void> deleteProductDocument(@PathVariable int productId, @PathVariable String documentNode) {
        ProductDocumentId id = new ProductDocumentId(productId, documentNode);
        productDocumentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
