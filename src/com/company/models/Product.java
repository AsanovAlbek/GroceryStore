package com.company.models;

public class Product {
    private long id;
    private String nameProduct; //Название продукта
    private String manufacturer; //Производитель
    private double price; //Цена
    private ProductType genre; //Вид продукта

    public Product(long id, String nameProducts, String manufacturer, double price, ProductType type) {
        this.id = id;
        this.nameProduct = nameProducts;
        this.manufacturer = manufacturer;
        this.price = price;
        this.genre = genre;
    }

    public Products()
    {
        //Пустой конструктор для выделения памяти под переменные
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProducts(String nameProduct) {
        this.nameProduct = nameProduct;
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

    public ProductType getGenre() {
        return genre;
    }

    public void setType(ProductType genre) {
        this.genre = genre;
    }

    Product() {
    }
}