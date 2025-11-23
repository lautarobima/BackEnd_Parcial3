package com.Proyect.BackEnd_Parcial3.model;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
@Table(name = "Employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> Products = new ArrayList<>();

    Employee() {
    }
    Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getPassword() {return password;}
}