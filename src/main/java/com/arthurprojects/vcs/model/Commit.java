package com.arthurprojects.vcs.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Commit {
    private String id;
    private String message;
    private String author;
    private LocalDateTime timestamp;
    private String parentId;
    private Map<String, String> fileHashes;

    public Commit(String author, Map<String, String> fileHashes,
                  String id, String message, String parentId, LocalDateTime timestamp) {
        this.author = author;
        this.fileHashes = fileHashes;
        this.id = id;
        this.message = message;
        this.parentId = parentId;
        this.timestamp = timestamp;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Map<String, String> getFileHashes() {
        return fileHashes;
    }

    public void setFileHashes(Map<String, String> fileHashes) {
        this.fileHashes = fileHashes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
