package ru.kovynev.provahtu.entities;

import jdk.jfr.Name;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user")
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @Column(name = "user_email")
    private String userEmail;
    private String password;
    @OneToMany
    private List<Resume> resumes;

    public Long getId_user() {
        return id_user;
    }


    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }



    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUsername(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUsername() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
