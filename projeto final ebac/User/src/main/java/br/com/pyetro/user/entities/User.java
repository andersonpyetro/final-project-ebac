package br.com.pyetro.user.entities;


import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
import java.util.UUID;

@Document
public class User {

    @Id
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private Date registerDate;

    @Min(value = 18, message = "A idade mínima é 18 anos")
    @Max(value = 120, message = "Peraí, Matusalém!")
    private int age;

    public User(){

    }

    public User(String name, String email, Date registerDate, int age) {
        this.name = name;
        this.email = email;
        this.registerDate = registerDate;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PrePersist
    @Transient
    public void createId(){
        this.id = UUID.randomUUID().toString();
    }
}
