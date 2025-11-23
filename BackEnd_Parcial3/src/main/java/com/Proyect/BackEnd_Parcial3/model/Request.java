package com.Proyect.BackEnd_Parcial3.model;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
@Table(name = "Requests")
public class Request {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> Products = new ArrayList<>();

    Request() {
    }
    Request(String name, String phone, String address, Double price) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.price = price;
    }
    Request(String name, String phone, String address, Double price, List<Product> products) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.price = price;
        this.Products = products;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public String getAddress() {return address;}
    public Double getPrice() {return price;}
    public List<Product> getProducts() {return Products;}
}
