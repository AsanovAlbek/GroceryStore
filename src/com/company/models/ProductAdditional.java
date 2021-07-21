package com.company.models;

public class ProductAdditional {

    private ProductType type;
    private int count;
    private double price;

    public ProductAdditional(){

    }

    public ProductAdditional(ProductType type, int count, double price) {
        this.type = type;
        this.count = count;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
