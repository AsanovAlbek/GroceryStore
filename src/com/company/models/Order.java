package com.company;

public class Order {
    private long id;
    private long buyersId; // кому продали
    private long sellersId; // кто продал
    private long[] products; // список номеров книг которые продали


    public Order(long id, long sellersId, long buyersId, long[] products) {
        this.id = id;
        this.buyersId = buyersId;
        this.sellersId = sellersId;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(long buyersId) {
        this.buyersId = buyersId;
    }

    public long getSellersId() {
        return sellersId;
    }

    public void setSellersId(long sellersId) {
        this.sellersId = sellersId;
    }

    public long[] getProducts() {
        return products;
    }

    public void setProducts(long[] products) {
        this.products = products;
    }
}

