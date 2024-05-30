package com.example.productionwebservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productionwebservice.dto.ProductPhotoDTO;
import com.example.productionwebservice.services.ProductPhotoService;

@RestController
@RequestMapping(path = "/productphotos")
public class ProductoPhotoController {
    @Autowired
    private ProductPhotoService productPhotoService;

    @GetMapping
    public List<ProductPhotoDTO> getAllProductPhotos() {
        return productPhotoService.getAll();
    }
}
