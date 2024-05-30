package com.example.productionwebservice.dto;

import java.time.LocalDateTime;

public class ProductPhotoDTO {

    private int productPhotoId;
    private byte[] thumbNailPhoto;
    private String thumbnailPhotoFileName;
    private byte[] largePhoto;
    private String largePhotoFileName;
    private LocalDateTime modifiedDate;

    // Default constructor
    public ProductPhotoDTO() {}

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
