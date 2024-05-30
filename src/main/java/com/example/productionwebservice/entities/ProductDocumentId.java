package com.example.productionwebservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductDocumentId implements Serializable {

    @Column(name = "ProductID")
    private int productId;

    @Column(name = "DocumentNode", columnDefinition = "hierarchyid")
    private String documentNode;

    // Constructors, getters, setters, equals, and hashCode methods

    public ProductDocumentId() {}

    public ProductDocumentId(int productId, String documentNode) {
        this.productId = productId;
        this.documentNode = documentNode;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDocumentNode() {
        return documentNode;
    }

    public void setDocumentNode(String documentNode) {
        this.documentNode = documentNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDocumentId that = (ProductDocumentId) o;
        return productId == that.productId && Objects.equals(documentNode, that.documentNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, documentNode);
    }
}
