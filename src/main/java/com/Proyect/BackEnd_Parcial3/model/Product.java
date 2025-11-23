package com.Proyect.BackEnd_Parcial3.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "genre")
    private String genre;
    @Column(name = "developer")
    private String developer;
    @Column(name = "boxArt")
    private String boxArt;
    @Column(name = "releaseDate")
    private String releaseDate;
    @Column(name = "price")
    private Double price;
    @Column(name = "offer")
    private Double offer;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "request_products",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "request_id")
    )
    private Set<Request> requests = new HashSet<>();

    Product() {
    }
    Product(String title, String genre, String developer, String boxArt, String releaseDate, Double price, Double offer) {
        this.title = title;
        this.genre = genre;
        this.developer = developer;
        this.boxArt = boxArt;
        this.releaseDate = releaseDate;
        this.price = price;
        this.offer = offer;
    }

    public Long getId() {return id;}
    public String getTitle() {return title;}
    public String getGenre() {return genre;}
    public String getDeveloper() {return developer;}
    public String getBoxArt() {return boxArt;}
    public String getReleaseDate() {return releaseDate;}
    public Double getPrice() {return price;}
    public Double getOffer() {return offer;}
    public Set<Request> getRequests() {return requests;}

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", genre=" + genre + ", developer=" + developer + ", boxArt="
                + boxArt + ", release=" + releaseDate + ", price=" + price + ", offer=" + offer + "]";
    }

}
