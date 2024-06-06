package com.example.productionwebservice.controllers;

import java.util.List;
import java.util.Optional;

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

import com.example.productionwebservice.dto.DocumentDTO;
import com.example.productionwebservice.entities.Document;
import com.example.productionwebservice.services.DocumentService;

@RestController
@RequestMapping(path = "/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("")
    public List<DocumentDTO> getDocuments() {
        return documentService.getAll();
    }

    @GetMapping("/{documentNode}")
    public ResponseEntity<Document> getDocumentById(@PathVariable String documentNode) {
        Optional<Document> document = documentService.getDocumentById(documentNode);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<DocumentDTO> createDocument(@RequestBody DocumentDTO documentDTO) {
        DocumentDTO createdDocument = documentService.create(documentDTO);
        return ResponseEntity.ok(createdDocument);
    }

    @PutMapping("/{documentNode}")
    public ResponseEntity<DocumentDTO> updateDocument(@PathVariable String documentNode, @RequestBody DocumentDTO documentDTO) {
        DocumentDTO updatedDocument = documentService.update(documentNode, documentDTO);
        if (updatedDocument != null) {
            return ResponseEntity.ok(updatedDocument);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{documentNode}")
    public ResponseEntity<Void> deleteDocument(@PathVariable String documentNode) {
        documentService.delete(documentNode);
        return ResponseEntity.noContent().build();
    }
}
