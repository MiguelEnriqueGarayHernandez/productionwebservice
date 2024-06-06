package com.example.productionwebservice.services;

import com.example.productionwebservice.dto.ProductPhotoDTO;
import com.example.productionwebservice.entities.ProductPhoto;
import com.example.productionwebservice.repositories.ProductPhotoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductPhotoService {
    @Autowired
    private ProductPhotoRepository productPhotoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductPhotoDTO> getAll() {
        return productPhotoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductPhotoDTO getProductPhotoById(int productPhotoId) {
        Optional<ProductPhoto> productPhoto = productPhotoRepository.findById(productPhotoId);
        return productPhoto.map(this::convertToDTO).orElse(null);
    }

    public ProductPhotoDTO create(ProductPhotoDTO productPhotoDTO){
        ProductPhoto product = modelMapper.map(productPhotoDTO, ProductPhoto.class);
        ProductPhoto savedProductPhoto = productPhotoRepository.save(product);
        return convertToDTO(savedProductPhoto);
    }

    public ProductPhotoDTO update(int productPhotoId, ProductPhotoDTO productPhotoDTO) {
        Optional<ProductPhoto> existingProductPhoto = productPhotoRepository.findById(productPhotoId);
        if (existingProductPhoto.isPresent()) {
            ProductPhoto productPhotoToUpdate = existingProductPhoto.get();
            modelMapper.map(productPhotoDTO, productPhotoToUpdate);
            ProductPhoto updatedProductPhoto = productPhotoRepository.save(productPhotoToUpdate);
            return convertToDTO(updatedProductPhoto);
        }
        return null;
    }

    public void delete(int productPhotoId) {
        productPhotoRepository.deleteById(productPhotoId);
    }

    private ProductPhotoDTO convertToDTO(ProductPhoto productPhoto) {
        return modelMapper.map(productPhoto, ProductPhotoDTO.class);
    }
}
