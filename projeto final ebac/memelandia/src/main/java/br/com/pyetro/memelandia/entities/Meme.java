package br.com.pyetro.memelandia.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Document(collection = "memes")
public class Meme {
    @Id
    private Long id;
    private String name;
    private String description;
    private Date registerDate;
    private MemeCategory memeCategory;
    private User user;
    private String newUserId;
    private String newMemeCategoryId;

    public Meme(){
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

    public MemeCategory getMemeCategory() {
        return memeCategory;
    }

    public void setMemeCategory(MemeCategory memeCategory) {
        this.memeCategory = memeCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewUserId() {
        return newUserId;
    }

    public void setNewUserId(String newUserId) {
        this.newUserId = newUserId;
    }

    public String getNewMemeCategoryId() {
        return newMemeCategoryId;
    }

    public void setNewMemeCategoryId(String newMemeCategoryId) {
        this.newMemeCategoryId = newMemeCategoryId;
    }
}
