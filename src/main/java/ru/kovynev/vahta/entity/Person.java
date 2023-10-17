package ru.kovynev.vahta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Person")
@Getter
@Setter
public class Person {

    @Id
    private Long id;
    private String name;
    private  String password;


    public Person() {
    }


}
