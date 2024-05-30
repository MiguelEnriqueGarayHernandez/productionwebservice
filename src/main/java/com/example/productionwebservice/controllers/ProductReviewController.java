package com.example.productionwebservice.controllers;

import com.example.productionwebservice.dto.ProductReviewDTO;
import com.example.productionwebservice.services.ProductReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productreviews")
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping
    public List<ProductReviewDTO> getAllReviews() {
        return productReviewService.getAll();
    }

    @GetMapping("/product/{productId}")
    public List<ProductReviewDTO> getReviewsByProductId(@PathVariable int productId) {
        return productReviewService.getReviewsByProductId(productId);
    }

    @GetMapping("/{reviewId}")
    public ProductReviewDTO getReviewById(@PathVariable int reviewId) {
        return productReviewService.getReviewById(reviewId);
    }

    @PostMapping
    public ProductReviewDTO createReview(@RequestBody ProductReviewDTO reviewDTO) {
        return productReviewService.create(reviewDTO);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        productReviewService.deleteReview(reviewId);
    }
}
