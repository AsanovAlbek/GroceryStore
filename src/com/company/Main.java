package com.company;

import com.company.models.*;

import java.util.ArrayList;         //Для использования списков
import java.util.Scanner;           //Для использования ввода

public class Main {

    static ArrayList<Products> product = new ArrayList<>();
    static ArrayList<Buyers> buyer = new ArrayList<>();
    static ArrayList<Sellers> seller = new ArrayList<>();
    static ArrayList<Order> order = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Initial();
        //Проверка функции CountOfProductsInAllOrders()
        int count = CountOfProductsInAllOrders();
        System.out.println("count = " + count);

        double price = PriceOfProductsInAllOrders();
        System.out.println("price = " + price);
    }

    /**
     *  Нахождение продукта по id
     * @param id - задаваемое функции значение, которое она должна найти
     * @return - результат функции - найденый по этому id продукт
     */
    public static Products getProductId(long id)
    {
           Products current = null;
           for (Products found : product)
           {
               if (found.getId() == id)
               {
                   current = found;
                   break;
               }
           }
           return current;
    }

    //Подсчёт купленных товаров во всех покупках
    public static int CountOfProductsInAllOrders(){
        int count = 0;
        for (Order order1 : order){
            count += order1.getProducts().length;
        }
        return count;
    }

    public static double PriceOfProductsInAllOrders()
    {
        double price = 0;
        for (Order order1: order)
        {
            price += PriceOfProductsInOneOrder(order1);
        }
        return price;
    }

    public static double PriceForOneProductType(Order order1, ProductType type){
        double price = 0;
        for (long productId: order1.getProducts()){
            Products products = getProductId(productId);
            if (products != null && products.getType() == type)
                price += products.getPrice();
        }
        return price;
    }

    //Функция для нахождения количества и цены всех продуктов определённого вида продуктов
    public static ArrayList<ProductAdditional> CountAndPriceOfProductsByProductType() {
        ArrayList<ProductAdditional> result = new ArrayList<>();
        int countMilkProducts = 0, countDessertsAndSweet = 0, countMeat = 0,
                countFish = 0, countVegetables = 0, countFruits = 0, countCereals = 0,
                    countSoftDrinks = 0, countAlcohol = 0;

        double priceMilkProducts = 0, priceDessertsAndSweet = 0, priceMeat = 0,
                priceFish = 0, priceVegetables = 0, priceFruits = 0, priceCereals = 0,
                priceSoftDrinks = 0, priceAlcohol = 0;

        for (Order order1 : order) {
            countMilkProducts += CountForOneProductType(order1, ProductType.MilkProducts);
            countDessertsAndSweet += CountForOneProductType(order1, ProductType.DessertsAndSweet);
            countMeat += CountForOneProductType(order1, ProductType.Meat);
            countFish += CountForOneProductType(order1, ProductType.fish);
            countVegetables += CountForOneProductType(order1, ProductType.Vegetables);
            countFruits += CountForOneProductType(order1, ProductType.Fruits);
            countCereals += CountForOneProductType(order1, ProductType.Cereals);
            countSoftDrinks += CountForOneProductType(order1, ProductType.SoftDrinks);
            countAlcohol += CountForOneProductType(order1, ProductType.Alcohol);

            priceMilkProducts += PriceForOneProductType(order1, ProductType.MilkProducts);
            priceDessertsAndSweet += PriceForOneProductType(order1, ProductType.DessertsAndSweet);
            priceMeat += PriceForOneProductType(order1, ProductType.Meat);
            priceFish += PriceForOneProductType(order1, ProductType.fish);
            priceVegetables += PriceForOneProductType(order1, ProductType.Vegetables);
            priceFruits += PriceForOneProductType(order1, ProductType.Fruits);
            priceCereals += PriceForOneProductType(order1, ProductType.Cereals);
            priceSoftDrinks += PriceForOneProductType(order1, ProductType.SoftDrinks);
            priceAlcohol += PriceForOneProductType(order1, ProductType.Alcohol);
        }

        result.add(new ProductAdditional(ProductType.MilkProducts, countMilkProducts, priceMilkProducts));
        result.add(new ProductAdditional(ProductType.DessertsAndSweet, countDessertsAndSweet, priceDessertsAndSweet));
        result.add(new ProductAdditional(ProductType.Meat, countMeat, priceMeat));
        result.add(new ProductAdditional(ProductType.fish, countFish, priceFish));
        result.add(new ProductAdditional(ProductType.Vegetables, countVegetables, priceVegetables));
        result.add(new ProductAdditional(ProductType.Fruits, countFruits, priceFruits));
        result.add(new ProductAdditional(ProductType.Cereals, countCereals, priceCereals));
        result.add(new ProductAdditional(ProductType.SoftDrinks, countSoftDrinks, priceSoftDrinks));
        result.add(new ProductAdditional(ProductType.Alcohol, countAlcohol, priceAlcohol));

        return  result;
    }

    /**
     * Функция для нахождения общей стоимости заказа
     * @param order1 Заказ, по которому ищется общая цена
     * @return Найденная стоимость заказа
     */
    public static double PriceOfProductsInOneOrder(Order order1){
        double price = 0;
        for (long productId: order1.getProducts()){
            Products products = getProductId(productId);
            if (products != null)
                price += products.getPrice();
        }
        return price;
    }

    /**
     *
     * @param order1    Заказ по которому находится общая цена
     * @param type      Категория продукта
     * @return          Количество продуктов указанной категории
     */
    public static int CountForOneProductType(Order order1, ProductType type){
        int count = 0;
        for (long productId: order1.getProducts()){
            Products products = getProductId(productId);
            if (products != null && products.getType() == type)
                count++;
        }
        return count;
    }

        public static void Initial()
        {
        //Продавцы
        seller.add(new Sellers(1, "Артур", 30));
        seller.add(new Sellers(2, "Зина", 64));
        seller.add(new Sellers(3, "Оля", 21));

        //Покупатели
        buyer.add(new Buyers(1, "Паша", 14));
        buyer.add(new Buyers(2, "Вера", 18));
        buyer.add(new Buyers(3, "Варя", 19));
        buyer.add(new Buyers(4, "Олег", 25));
        buyer.add(new Buyers(5, "Семён", 33));
        buyer.add(new Buyers(6, "Руслан", 20));
        buyer.add(new Buyers(7, "Катя", 16));

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
        product.add(new Products(11, "Сосиски Халяль", "Райан", 95.5, ProductType.Meat));
        product.add(new Products(12, "Пельмени Халяль", "Райан", 114.5, ProductType.Meat));
        product.add(new Products(13, "Фарш (кг)", "ООО Джед", 300, ProductType.Meat));
        product.add(new Products(14, "Яица", "ООО Джед (10 шт)", 70, ProductType.Meat));
        product.add(new Products(15, "Колбаса Докторская", "ООО не повезло доктору", 109.99, ProductType.Meat));

        //Рыба
        product.add(new Products(16, "Селёдка", "Домик Рыбака", 75, ProductType.fish));
        product.add(new Products(17, "Карп", "Домик Рыбака", 250, ProductType.fish));
        product.add(new Products(18, "Вобла", "ООО Фишер", 200, ProductType.fish));
        product.add(new Products(19, "Икра Чёрная", "ООО Фишер", 190, ProductType.fish));
        product.add(new Products(20, "Икра Красная", "ООО Фишер", 230, ProductType.fish));

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

        //Покупки
            order.add(new Order(1, 1, 1, new long[]{1,5,7,9}));
            order.add(new Order(2, 2 , 1, new long[]{14, 8, 29, 3, 19}));
            order.add(new Order(3, 5 , 2, new long[]{45, 36, 19, 20}));
            order.add(new Order(4, 7 , 3, new long[]{43, 40, 16}));
            order.add(new Order(5, 3 , 3, new long[]{4, 8, 22}));
            order.add(new Order(6, 4 , 1, new long[]{44, 38, 18, 33}));
            order.add(new Order(7, 6 , 2, new long[]{11, 22, 33, 44}));
    }
}
