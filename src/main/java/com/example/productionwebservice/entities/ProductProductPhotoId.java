package com.example.productionwebservice.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductProductPhotoId implements Serializable {
    private int productId;
    private int productPhotoId;

    // Getters, Setters, equals, and hashCode
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductPhotoId() {
        return productPhotoId;
    }

    public void setProductPhotoId(int productPhotoId) {
        this.productPhotoId = productPhotoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductProductPhotoId that = (ProductProductPhotoId) o;
        return productId == that.productId && productPhotoId == that.productPhotoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productPhotoId);
    }
}
