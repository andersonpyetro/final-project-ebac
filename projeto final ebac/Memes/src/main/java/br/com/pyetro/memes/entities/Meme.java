package br.com.pyetro.memes.entities;


import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
public class Meme {
    @Id
    private String id;
    private String name;
    private String description;
    private Date registerDate;
    private String url;
    private String categoryMemeId;
    private String userId;
    public Meme(){
    }

    public Meme(String name, String description, Date registerDate, String url, String categoryMemeId, String userId) {
        this.name = name;
        this.description = description;
        this.registerDate = registerDate;
        this.url = url;
        this.categoryMemeId = categoryMemeId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategoryMemeId() {
        return categoryMemeId;
    }

    public void setCategoryMemeId(String categoryMemeId) {
        this.categoryMemeId = categoryMemeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Transient
    @PrePersist
    public void createId(){
        this.id = UUID.randomUUID().toString();
    }
}
