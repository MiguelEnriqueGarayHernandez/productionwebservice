package com.example.productionwebservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productionwebservice.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
    Optional<Document> findByDocumentNode(String documentNode);

    
}
