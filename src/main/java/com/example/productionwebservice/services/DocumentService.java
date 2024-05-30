package com.example.productionwebservice.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productionwebservice.dto.DocumentDTO;
import com.example.productionwebservice.entities.Document;
import com.example.productionwebservice.repositories.DocumentRepository;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Optional<Document> getDocumentById(String documentNode) {
        return documentRepository.findByDocumentNode(documentNode);
    }
    
    public List<DocumentDTO> getAll(){
        return documentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DocumentDTO create(DocumentDTO documentDTO) {
        Document document = modelMapper.map(documentDTO, Document.class);
        Document savedDocument = documentRepository.save(document);
        return convertToDTO(savedDocument);
    }

    public void delete(String documentNode) {
        documentRepository.deleteById(documentNode);
    }

    private DocumentDTO convertToDTO(Document document){
        return modelMapper.map(document, DocumentDTO.class);
    }
}
