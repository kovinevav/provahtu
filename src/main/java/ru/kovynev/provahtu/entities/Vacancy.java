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

    @Override
    public String toString() {
        return "Vacancy{" +
                "Id_vacancy=" + id_vacancy +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
