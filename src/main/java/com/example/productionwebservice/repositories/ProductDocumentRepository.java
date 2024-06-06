package com.example.productionwebservice.repositories;

import com.example.productionwebservice.entities.ProductDocument;
import com.example.productionwebservice.entities.ProductDocumentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDocumentRepository extends JpaRepository<ProductDocument, ProductDocumentId> {
}
