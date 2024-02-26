package br.com.pyetro.memelandia.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "memes")
public class MemeDTO implements Serializable {

    @Id
    private final String id;
    private final String name;
    private final String description;
    private final Date registerDate;
    private final String url;
    private final String userId;

    public MemeDTO(String id, String name, String description, Date registerDate, String url, String userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.registerDate = registerDate;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public String getUserId() {
        return userId;
    }
}
