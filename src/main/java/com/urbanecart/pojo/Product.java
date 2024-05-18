package com.urbanecart.pojo;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    private int id;
    private String title;
    private String description;
    private int price;
    private long discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String thumbnail;
    @ElementCollection
    private List<String> images;
    @ManyToOne
    @JoinColumn(name = "category_name")
    private Category category;

}
