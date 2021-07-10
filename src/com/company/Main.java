package com.company;

import GroceryStore.model.Buyers;
import GroceryStore.model.Sellers;
import GroceryStore.model.Products;
import GroceryStore.model.Order;

public class Main {

    static ArrayList<Products> product = new ArrayList<>();
    static ArrayList<Buyers> buyer = new ArrayList<>();
    static ArrayList<Sellers> seller = new ArrayList<>();
    static ArrayList<Order> order = new ArrayList<>();

    public static void main(String[] args) {

    }

    static void Initial{
        //Продавцы
        seller.add(new Sellers(1, "Артур", 30));
        seller.add(new Sellers(2, "Зина", 64));
        seller.add(new Sellers(3, "Оля", 21));

        //Покупатели
        buyer.add(new Buyers(1, "Паша", 14));
        buyer.add(new Buyers(1, "Вера", 18));
        buyer.add(new Buyers(1, "Варя", 19));
        buyer.add(new Buyers(1, "Олег", 25));
        buyer.add(new Buyers(1, "Семён", 33));
        buyer.add(new Buyers(1, "Руслан", 20));
        buyer.add(new Buyers(1, "Катя", 16));

        //Продукты

        //Молочные продукты
        product.add(new Products(1, "Сметана", "Домик в деревне", 80, ProductType.MilkProducts));
        product.add(new Products(2, "Молоко", "Простоквашино", 60, ProductType.MilkProducts));
        product.add(new Products(3, "Айран", "Кавказский долгожитель", 100, ProductType.MilkProducts));
        product.add(new Products(4, "Кефир", "Ряженка", 40, ProductType.MilkProducts));
        product.add(new Products(5, "Творог", "Домик в деревне", 55, ProductType.MilkProducts));

        //Десерты и сладости
        product.add(new Products(6, "Сникерс", "ООО Импорт", 35.99, ProductType.DessertsAndSweet));
        roduct.add(new Products(6, "Твикс", "ООО Импорт", 35.99, ProductType.DessertsAndSweet));
    }
}
