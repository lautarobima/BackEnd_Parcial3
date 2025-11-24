package com.Proyect.BackEnd_Parcial3.model;

import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

import jakarta.persistence.*;

@Entity
@Table(name = "requests")
public class Request {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "price")
    private Double price;
    @Column(name = "status") // pendiente or atendido
    private String status;
    @Column(name = "cuantity")
    private HashMap<Long, Integer> cuantity = new HashMap<>();
    //@Column(name = "products")
    //private List<Long> Products = new ArrayList<>();
    @ManyToMany(mappedBy = "requests")
    private Set<Product> products = new HashSet<>();

    Request() {
    }
    Request(String name, String phone, String address, Double price, String status) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.price = price;
        this.status = status;
    }
    Request(String name, String phone, String address, Double price, String status, Set<Product> products) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.price = price;
        this.status = status;
        this.products = products;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public String getAddress() {return address;}
    public Double getPrice() {return price;}
    public String getStatus() {return status;}
    public HashMap<Long, Integer> getCuantity() {return cuantity;}
    public Set<Product> getProducts() {return products;}
}
