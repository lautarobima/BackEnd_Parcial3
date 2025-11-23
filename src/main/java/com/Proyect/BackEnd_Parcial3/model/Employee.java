package com.Proyect.BackEnd_Parcial3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    Employee() {
    }
    Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getPassword() {return password;}

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", password=" + password + "]";
    }
}