package br.com.pyetro.category.entities;


import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
public class MemeCategory {

   @Id
    private String id;
   private String name;
   private String description;
   private Date registerDate;
   private String userId;

    public MemeCategory(String name, String description, Date registerDate, String userId) {
        this.name = name;
        this.description = description;
        this.registerDate = registerDate;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void createId(){
        this.id = UUID.randomUUID().toString();
    }
}
