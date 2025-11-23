package com.Proyect.BackEnd_Parcial3.model;

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
    @Column(name = "release_date")
    private String release_date;
    @Column(name = "price")
    private Double price;
    @Column(name = "offer")
    private Double offer;

    Product() {
    }
    Product(String title, String genre, String developer, String boxArt, String release_date, Double price, Double offer) {
        this.title = title;
        this.genre = genre;
        this.developer = developer;
        this.boxArt = boxArt;
        this.release_date = release_date;
        this.price = price;
        this.offer = offer;
    }

    public Long getId() {return id;}
    public String getTitle() {return title;}
    public String getGenre() {return genre;}
    public String getDeveloper() {return developer;}
    public String getBoxArt() {return boxArt;}
    public String getReleaseDate() {return release_date;}
    public Double getPrice() {return price;}
    public Double getOffer() {return offer;}

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", genre=" + genre + ", developer=" + developer + ", boxArt="
                + boxArt + ", release=" + release_date + ", price=" + price + ", offer=" + offer + "]";
    }

}
