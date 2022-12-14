package ru.kovynev.provahtu.entities;

import jdk.jfr.Name;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacancy")
    Long id_vacancy;
    @Column(name = "name")
    String name;
    @Column(name = "city")
    String city;
    @Column(name = "experience")
    String experience;

    @Column(name = "shortDescription")
    String shortDescription;

    @Column(name = "description")
    String description;
    @Column(name = "salary")
    String salary;

    public Vacancy() {

    }

    public Long getId_vacancy() {
        return id_vacancy;
    }

    public void setId_vacancy(Long id_vacancy) {
        id_vacancy = id_vacancy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id_vacancy=" + id_vacancy +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", experience='" + experience + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
