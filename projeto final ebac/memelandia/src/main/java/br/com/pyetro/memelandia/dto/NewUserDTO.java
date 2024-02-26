package br.com.pyetro.memelandia.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "new_users")
public class NewUserDTO implements Serializable {
    private final String id;
    private final String name;
    private final String email;
    private final Date registerDate;
    private int age;

    public NewUserDTO(String id, String name, String email, Date registerDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registerDate = registerDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
