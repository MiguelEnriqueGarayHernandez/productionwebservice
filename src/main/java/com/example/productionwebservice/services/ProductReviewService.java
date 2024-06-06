package com.example.productionwebservice.services;

import com.example.productionwebservice.dto.ProductReviewDTO;
import com.example.productionwebservice.entities.Product;
import com.example.productionwebservice.entities.ProductReview;
import com.example.productionwebservice.repositories.ProductRepository;
import com.example.productionwebservice.repositories.ProductReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductReviewService {
    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductReviewDTO> getAll() {
        return productReviewRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ProductReviewDTO> getReviewsByProductId(int productId) {
        List<ProductReview> reviews = productReviewRepository.findByProduct_ProductId(productId);
        return reviews.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductReviewDTO getReviewById(int productReviewId) {
        Optional<ProductReview> productReview = productReviewRepository.findById(productReviewId);
        return productReview.map(this::convertToDTO).orElse(null);
    }

    public ProductReviewDTO create(ProductReviewDTO dto) {
        Optional<Product> product = productRepository.findById(dto.getProductId());
        if (product.isPresent()) {
            ProductReview productReview = modelMapper.map(dto, ProductReview.class);
            productReview.setProduct(product.get());
            ProductReview savedProductReview = productReviewRepository.save(productReview);
            return convertToDTO(savedProductReview);
        }
        return null;
    }

    public ProductReviewDTO update(int reviewId, ProductReviewDTO dto) {
        Optional<ProductReview> existingReview = productReviewRepository.findById(reviewId);
        if (existingReview.isPresent()) {
            ProductReview reviewToUpdate = existingReview.get();
            modelMapper.map(dto, reviewToUpdate);
            reviewToUpdate.setProduct(productRepository.findById(dto.getProductId()).orElse(null));
            ProductReview updatedReview = productReviewRepository.save(reviewToUpdate);
            return convertToDTO(updatedReview);
        }
        return null;
    }

    public void deleteReview(int productReviewId) {
        productReviewRepository.deleteById(productReviewId);
    }

    private ProductReviewDTO convertToDTO(ProductReview productReview) {
        return modelMapper.map(productReview, ProductReviewDTO.class);
    }
}
