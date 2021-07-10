package com.company.models;

public class Products {
    private long id;
    private String nameProducts; //Название продукта
    private String manufacturer; //Производитель
    private double price; //Цена
    private ProductType type; //Вид продукта

    public Products(long id, String nameProducts, String manufacturer, double price, ProductType type) {
        this.id = id;
        this.nameProducts = nameProducts;
        this.manufacturer = manufacturer;
        this.price = price;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
