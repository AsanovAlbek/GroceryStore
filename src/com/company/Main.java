package com.company;

import com.company.models.Buyers;
import com.company.models.ProductType;
import com.company.models.Sellers;
import com.company.models.Products;
import com.company.models.Order;

import java.util.ArrayList;

public class Main {

    static ArrayList<Products> product = new ArrayList<>();
    static ArrayList<Buyers> buyer = new ArrayList<>();
    static ArrayList<Sellers> seller = new ArrayList<>();
    static ArrayList<Order> order = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("hh");
    }

    public static void Initial
        {
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
        product.add(new Products(7, "Твикс", "ООО Импорт", 37.99, ProductType.DessertsAndSweet));
        product.add(new Products(8, "Марс", "ООО Импорт", 39.99, ProductType.DessertsAndSweet));
        product.add(new Products(9, "35", "ООО Наше", 34.99, ProductType.DessertsAndSweet));
        product.add(new Products(10, "Красный Мак (кг)", "ООО Наше", 159.99, ProductType.DessertsAndSweet));

        //Мясо
        product.add(new Products(11, "Сосиски Халяль", "Райан", 95.5, ProductType.Meat);
        product.add(new Products(12, "Пельмени Халяль", "Райан", 114.5, ProductType.Meat);
        product.add(new Products(13, "Фарш (кг)", "ООО Джед", 300, ProductType.Meat);
        product.add(new Products(14, "Яица", "ООО Джед (10 шт)", 70, ProductType.Meat);
        product.add(new Products(15, "Колбаса Докторская", "ООО не повезло доктору", 109.99, ProductType.Meat);

        //Рыба
        product.add(new Products(16, "Селёдка", "Домик Рыбака", 75, ProductType.fish);
        product.add(new Products(17, "Карп", "Домик Рыбака", 250, ProductType.fish);
        product.add(new Products(18, "Вобла", "ООО Фишер", 200, ProductType.fish);
        product.add(new Products(19, "Икра Чёрная", "ООО Фишер", 190, ProductType.fish);
        product.add(new Products(20, "Икра Красная", "ООО Фишер", 230, ProductType.fish);

        //Овощи
        product.add(new Products(21, "Картошка (кг)", "ООО Всё Своё", 40, ProductType.Vegetables));
        product.add(new Products(22, "Редиска (кг)", "ООО Всё Своё", 50, ProductType.Vegetables));
        product.add(new Products(23, "Помидоры (кг)", "ООО Всё Своё", 80, ProductType.Vegetables));
        product.add(new Products(24, "Огурцы (кг)", "ООО Всё Своё", 75, ProductType.Vegetables));
        product.add(new Products(25, "Картошка", "ООО Всё Своё", 40, ProductType.Vegetables));

        //Фрукты
        product.add(new Products(26, "Яблоки (кг)", "ООО Всё Своё", 70, ProductType.Fruits));
        product.add(new Products(27, "Груши (кг)", "ООО Всё Своё", 70, ProductType.Fruits));
        product.add(new Products(28, "Лимон (шт)", "ООО Всё Своё", 20, ProductType.Fruits));
        product.add(new Products(29, "Вишни (кг)", "ООО Всё Своё", 100, ProductType.Fruits));
        product.add(new Products(30, "Персики (кг)", "ООО Всё Своё", 95, ProductType.Fruits));

        //Крупы
        product.add(new Products(31, "Рис", "Здоровая Страна", 30, ProductType.Cereals));
        product.add(new Products(32, "Овсянка", "Здоровая Страна", 35, ProductType.Cereals));
        product.add(new Products(33, "Кукурузная Крупа", "Здоровая Страна", 37, ProductType.Cereals));
        product.add(new Products(34, "Пшеничная Крупа", "Здоровая Страна", 45, ProductType.Cereals));
        product.add(new Products(35, "Манка", "Здоровая Страна", 39, ProductType.Cereals));

        //Безалкогольные напитки
        product.add(new Products(36, "Кола", "CocaCola", 90, ProductType.SoftDrinks));
        product.add(new Products(37, "Пепси", "PepsiCola", 95, ProductType.SoftDrinks));
        product.add(new Products(38, "Лимонад", "ООО Халвичный завод нальчинский", 25, ProductType.SoftDrinks));
        product.add(new Products(39, "Тархун", "ООО Халвичный завод нальчинский", 30, ProductType.SoftDrinks));
        product.add(new Products(40, "Мохито", "ООО Халвичный завод нальчинский", 35, ProductType.SoftDrinks));

        //Алкоголь
        product.add(new Products(41, "Водка", "ООО Алкаш", 299.9, ProductType.Alcohol));
        product.add(new Products(42, "Вино", "ООО Ценитель", 3799.9, ProductType.Alcohol));
        product.add(new Products(43, "Коньяк", "ООО Ценитель", 2799.9, ProductType.Alcohol));
        product.add(new Products(44, "Чача", "ООО Алкаш", 999.9, ProductType.Alcohol));
        product.add(new Products(45, "Виски", "Propper Twelve", 6799.9, ProductType.Alcohol));
    }
}
