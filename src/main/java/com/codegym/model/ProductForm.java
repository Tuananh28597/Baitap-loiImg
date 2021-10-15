package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private int id;
    private String name;
    private String color;
    private String price;
    private MultipartFile image;

    public ProductForm(int id, String name, String color, String price, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.image = image;
    }

    public ProductForm() {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
