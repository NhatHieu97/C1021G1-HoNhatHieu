package com.codegym.model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int quantily;
    private String color;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double price, int quantily, String color) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantily = quantily;
        this.color = color;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
