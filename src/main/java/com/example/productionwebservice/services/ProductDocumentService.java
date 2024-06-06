package com.example.productionwebservice.services;

import com.example.productionwebservice.dto.ProductDocumentDTO;
import com.example.productionwebservice.entities.ProductDocument;
import com.example.productionwebservice.entities.ProductDocumentId;
import com.example.productionwebservice.repositories.ProductDocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductDocumentService {

    @Autowired
    private ProductDocumentRepository productDocumentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDocumentDTO> getAll() {
        List<ProductDocument> productDocuments = productDocumentRepository.findAll();
        return productDocuments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductDocumentDTO> getById(ProductDocumentId id) {
        Optional<ProductDocument> productDocument = productDocumentRepository.findById(id);
        return productDocument.map(this::convertToDto);
    }

    public ProductDocumentDTO create(ProductDocumentDTO productDocumentDTO) {
        ProductDocument productDocument = modelMapper.map(productDocumentDTO, ProductDocument.class);
        ProductDocument savedProductDocument = productDocumentRepository.save(productDocument);
        return convertToDto(savedProductDocument);
    }

    public ProductDocumentDTO update(ProductDocumentId id, ProductDocumentDTO productDocumentDTO) {
        Optional<ProductDocument> existingProductDocument = productDocumentRepository.findById(id);
        if (existingProductDocument.isPresent()) {
            ProductDocument productDocumentToUpdate = existingProductDocument.get();
            modelMapper.map(productDocumentDTO, productDocumentToUpdate);
            ProductDocument updatedProductDocument = productDocumentRepository.save(productDocumentToUpdate);
            return convertToDto(updatedProductDocument);
        }
        return null;
    }

    public void delete(ProductDocumentId id) {
        productDocumentRepository.deleteById(id);
    }

    private ProductDocumentDTO convertToDto(ProductDocument productDocument) {
        return modelMapper.map(productDocument, ProductDocumentDTO.class);
    }
}
