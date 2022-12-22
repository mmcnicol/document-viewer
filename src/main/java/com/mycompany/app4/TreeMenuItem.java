package com.mycompany.app4;

public class TreeMenuItem {
    private String documentDate;
    private String documentId;
    private String fileExtension;

    public TreeMenuItem(String documentDate, String documentId, String fileExtension) {
        this.documentDate = documentDate;
        this.documentId = documentId;
        this.fileExtension = fileExtension;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
    
    
    
    @Override
    public String toString() {
        return documentDate;
    }
    
    
}
