package com.example.demo.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Timestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "message")
public class MessageEntity {

    @Id
    private UUID id;

    private String text;

    public MessageEntity() {
    }

    public MessageEntity(UUID id, String text) {
        this.id = id;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}