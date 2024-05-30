package com.example.productionwebservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "ProductProductPhoto", schema = "Production")
public class ProductProductPhoto {
    @EmbeddedId
    private ProductProductPhotoId productId;

    @Column(name = "Primary", nullable = false)
    private boolean primaryFlag;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "ProductID")
    private Product product;

    @ManyToOne
    @MapsId("productPhotoId")
    @JoinColumn(name = "ProductPhotoID")
    private ProductPhoto productPhoto;

    // Getters and Setters
    public ProductProductPhotoId getId() {
        return productId;
    }

    public void setId(ProductProductPhotoId productId) {
        this.productId = productId;
    }

    public boolean isPrimaryFlag() {
        return primaryFlag;
    }

    public void setPrimaryFlag(boolean primaryFlag) {
        this.primaryFlag = primaryFlag;
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

    public ProductPhoto getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(ProductPhoto productPhoto) {
        this.productPhoto = productPhoto;
    }
}
