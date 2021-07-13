package com.bazarek.bazarek.wallet.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Product implements Serializable {
    private long idProduct;
    private String name;
    private double price;

    public Product(long idProduct, String name, double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
