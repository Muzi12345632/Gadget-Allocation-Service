package com.example.demo.models;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;


@Entity
@Table(name="employee")
public class Employee {

    //TODO Methods for employee
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "employee_sequence",sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long id;
    @Column(name="name", nullable = true)
    private String name;

    @Column(name="surname",nullable = true)
    private String surname;

    @Column(name="username",nullable = true)
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private List<Gadget> gadget;


    public Employee(String name, String surname, String username) {
        //this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public Employee(){

    }

    public List<Gadget> getGadget() {
        return gadget;
    }

    public void setGadget(List<Gadget> gadget) {
        this.gadget = gadget;
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
        name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        username = username;
    }

}
