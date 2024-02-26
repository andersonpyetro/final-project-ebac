package br.com.pyetro.memelandia.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "meme_categories")
public class MemeCategory {

    @Id
    private Long id;
    private String name;
    private String description;
    private Date registerDate;
    private User user;
    private String newUserId;

    public User getUser(){
        return user;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewUserId() {
        return newUserId;
    }

    public void setNewUserId(String userId) {
        this.newUserId = userId;
    }
}
