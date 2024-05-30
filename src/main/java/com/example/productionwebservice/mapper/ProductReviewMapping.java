package com.example.productionwebservice.mapper;

import org.modelmapper.PropertyMap;

import com.example.productionwebservice.dto.ProductReviewDTO;
import com.example.productionwebservice.entities.ProductReview;

public class ProductReviewMapping extends PropertyMap<ProductReview, ProductReviewDTO> {
    @Override
    protected void configure() {
        map().setProductId(source.getProduct().getProductId());
    }
}
