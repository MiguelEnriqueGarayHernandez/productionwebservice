package com.example.productionwebservice.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductPhoto", schema = "Production")
public class ProductPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductPhotoID")
    private int productPhotoId;

    @Lob
    @Column(name = "ThumbNailPhoto", nullable = true)
    private byte[] thumbNailPhoto;

    @Column(name = "ThumbnailPhotoFileName", length = 50, nullable = true)
    private String thumbnailPhotoFileName;

    @Lob
    @Column(name = "LargePhoto", nullable = true)
    private byte[] largePhoto;

    @Column(name = "LargePhotoFileName", length = 50, nullable = true)
    private String largePhotoFileName;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    // Default constructor
    public ProductPhoto() {}

    // Getters and setters
    public int getProductPhotoId() {
        return productPhotoId;
    }

    public void setProductPhotoId(int productPhotoId) {
        this.productPhotoId = productPhotoId;
    }

    public byte[] getThumbNailPhoto() {
        return thumbNailPhoto;
    }

    public void setThumbNailPhoto(byte[] thumbNailPhoto) {
        this.thumbNailPhoto = thumbNailPhoto;
    }

    public String getThumbnailPhotoFileName() {
        return thumbnailPhotoFileName;
    }

    public void setThumbnailPhotoFileName(String thumbnailPhotoFileName) {
        this.thumbnailPhotoFileName = thumbnailPhotoFileName;
    }

    public byte[] getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(byte[] largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getLargePhotoFileName() {
        return largePhotoFileName;
    }

    public void setLargePhotoFileName(String largePhotoFileName) {
        this.largePhotoFileName = largePhotoFileName;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
