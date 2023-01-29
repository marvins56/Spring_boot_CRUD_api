package com.example.crudapi.model;

import org.hibernate.annotations.IdGeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {

    //DEFINING primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //defining names
    @Column(name="First Name",nullable = false)
    private String FirstName;
    @Column(name="Last Name",nullable = false)
    private String LatName;
    @Column(name="Email",nullable = false)
    private String email;

}
