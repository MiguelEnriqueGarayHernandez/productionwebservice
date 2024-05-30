package com.example.productionwebservice.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Document", schema = "Production")
public class Document {
    @Id
    @Column(name = "DocumentNode", columnDefinition = "hierarchyid")
    private String documentNode;

    @Column(name = "DocumentLevel", insertable = false, updatable = false)
    private Short documentLevel;

    @Column(name = "Title", nullable = false, length = 50)
    private String title;

    @Column(name = "FolderFlag", nullable = false)
    private boolean folderFlag;

    @Column(name = "FileName", nullable = false, length = 400)
    private String fileName;

    @Column(name = "FileExtension", nullable = false, length = 8)
    private String fileExtension;

    @Column(name = "Revision", nullable = false, length = 5)
    private String revision;

    @Column(name = "ChangeNumber", nullable = false)
    private int changeNumber;

    @Column(name = "Status", nullable = false)
    private byte status;

    @Column(name = "DocumentSummary")
    private String documentSummary;

    @Column(name = "Document")
    private byte[] document;

    @Column(name = "rowguid", nullable = false, unique = true)
    private UUID rowguid;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    // Getters and Setters

    public String getDocumentNode() {
        return documentNode;
    }

    public void setDocumentNode(String documentNode) {
        this.documentNode = documentNode;
    }

    public Short getDocumentLevel() {
        return documentLevel;
    }

    public void setDocumentLevel(Short documentLevel) {
        this.documentLevel = documentLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFolderFlag() {
        return folderFlag;
    }

    public void setFolderFlag(boolean folderFlag) {
        this.folderFlag = folderFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public int getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(int changeNumber) {
        this.changeNumber = changeNumber;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getDocumentSummary() {
        return documentSummary;
    }

    public void setDocumentSummary(String documentSummary) {
        this.documentSummary = documentSummary;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public UUID getRowguid() {
        return rowguid;
    }

    public void setRowguid(UUID rowguid) {
        this.rowguid = rowguid;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
