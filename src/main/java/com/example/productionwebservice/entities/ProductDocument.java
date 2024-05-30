package com.example.productionwebservice.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductDocument", schema = "Production")
public class ProductDocument {

    @EmbeddedId
    private ProductDocumentId id;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "ProductID", nullable = false)
    private Product product;

    @ManyToOne
    @MapsId("documentNode")
    @JoinColumn(name = "DocumentNode", nullable = false, columnDefinition = "hierarchyid")
    private Document document;

    // Getters and Setters

    public ProductDocumentId getId() {
        return id;
    }

    public void setId(ProductDocumentId id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
