package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String color;
    private String price;
    private String image;



    public Product(int id, String name, String color, String price, String image) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.image = image;
    }

    public Product() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
