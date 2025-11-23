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
    @Column(name = "release")
    private String release;
    @Column(name = "price")
    private Double price;

    Product() {
    }
    Product(String title, String genre, String developer, String boxArt, String release, Double price) {
        this.title = title;
        this.genre = genre;
        this.developer = developer;
        this.boxArt = boxArt;
        this.release = release;
        this.price = price;
    }

    public Long getId() {return id;}
    public String getTitle() {return title;}
    public String getGenre() {return genre;}
    public String getDeveloper() {return developer;}
    public String getBoxArt() {return boxArt;}
    public String getRelease() {return release;}
    public Double getPrice() {return price;}

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", genre=" + genre + ", developer=" + developer + ", boxArt="
                + boxArt + ", release=" + release + ", price=" + price + "]";
    }

}
