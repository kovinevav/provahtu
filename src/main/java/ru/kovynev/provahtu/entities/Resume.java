package ru.kovynev.provahtu.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "resume")
public class Resume extends Anketa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id_resume;
    @OneToOne(fetch = FetchType.LAZY)
    User user;
    String name;
    String lastname;
    String patronymic;
    String date;
    String gender;
    String city;
    String phone;
    String email;
    String post;
    double salary;



    public long getId_resume() {
        return id_resume;
    }

    public void setId_resume(long id_resume) {
        this.id_resume = id_resume;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String sity) {
        this.city = sity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

