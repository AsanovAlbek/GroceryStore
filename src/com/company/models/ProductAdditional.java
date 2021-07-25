package com.company;

public class ProductAdditional {
    private ProductType genre;
    private int count;


    public ProductAdditional(ProductType genre, int count) {
        this.genre = genre;
        this.count = count;
    }

    public ProductType getGenre() {
        return genre;
    }

    public void setGenre(ProductType genre) {
        this.genre = genre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

