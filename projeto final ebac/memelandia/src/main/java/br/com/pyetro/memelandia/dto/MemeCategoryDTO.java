package br.com.pyetro.memelandia.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "meme_categories")
public class MemeCategoryDTO implements Serializable {

    private final String id;
    private final String name;
    private final String description;
    private final Date registerDate;
    private final String userId;
    public MemeCategoryDTO(String id, String name, String description, Date registerDate, String userId) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public String getUserId() {
        return userId;
    }
}
