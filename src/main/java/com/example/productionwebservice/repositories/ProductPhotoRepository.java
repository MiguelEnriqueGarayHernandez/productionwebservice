package com.example.productionwebservice.repositories;

import com.example.productionwebservice.entities.ProductPhoto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Integer> {
    Optional<ProductPhoto> findByProductPhotoId(int productId);
}
