package com.company;

import com.company.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Buyers> buyers = new ArrayList<>();
    static ArrayList<Sellers> sellers = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here
        Initial();
        // задача№1
        String productsInfo = String.format("ОБщее количество проданных продуктов %d на сумму %f", getCountOfSoldProducts(), getAllPriceOfSoldProducts());
        System.out.println(productsInfo);

        // задача №2
        for (Sellers sellers : sellers) {
            System.out.println(sellers.getName() + " продал(а)" + getProfitBySellers(sellers.getId()));
        }
        // задача №3
        ArrayList<ProductAdditional> soldProductsCount = getCountOfSoldProductsByGenre();
        HashMap<ProductType, Double> soldProductsPrices = getPriceOfSoldProductsByGenre();

        String soldProductStr = "По типу: %s продано %d продуктов общей стоимостью %f";

        for (ProductAdditional productAdditional : soldProductsCount) {
            double price = soldProductsPrices.get(productAdditional.getGenre());
            System.out.println(
                    String.format(
                            soldProductStr,
                            productAdditional.getGenre().name(), productAdditional.getCount(), price));
        }

        // задача №4
        int age = 30;
        String analyzeGenreStr ="Покупатели до %d лет выбирают тип %s";
        System.out.println(String.format(analyzeGenreStr,30,getMostPopularGenreLessThenAge(30)));

        // задача №4
        String analyzeGenreStr2 ="Покупатели старше %d лет выбирают тип %s";
        System.out.println(String.format(analyzeGenreStr2,30,getMostPopularGenreMoreThenAge(30)));

    }

    // наиболее популярный тип по возрасту
    public static ProductType getMostPopularGenreLessThenAge(int age) {
        ArrayList<Long> buyersIds = new ArrayList<>();
        for (Buyers buyers: buyers) {
            if (buyers.getAge() < age) {
                buyersIds.add(buyers.getId());
            }
        }

        return getMostPopularProductType(buyersIds);
    }

    // наиболее популярный тип по возрасту старше age
    public static ProductType getMostPopularGenreMoreThenAge(int age) {
        ArrayList<Long> buyersIds = new ArrayList<>();
        for (Buyers buyers: buyers) {
            if (buyers.getAge() > age) {
                buyersIds.add(buyers.getId());
            }
        }

        return getMostPopularProductType(buyersIds);
    }

    private static ProductType getMostPopularProductType(ArrayList<Long> buyersIds) {
        int countMilkProducts = 0, countDessertsAndSweet = 0, countMeat = 0,
                countFish = 0, countVegetables = 0, countFruits = 0, countCereals = 0,
                countSoftDrinks = 0, countAlcohol = 0;

        for (Order order:orders) {
            if (buyersIds.contains(order.getBuyersId())) {
                countMeat += getCountOfSoldByGenre(order, ProductType.Meat);
                countFish += getCountOfSoldByGenre(order, ProductType.Fish);
                countFruits += getCountOfSoldByGenre(order, ProductType.Fruits);
                countMilkProducts += getCountOfSoldByGenre(order, ProductType.MilkProducts);
                countDessertsAndSweet += getCountOfSoldByGenre(order, ProductType.DessertsAndSweet);
                countVegetables += getCountOfSoldByGenre(order, ProductType.Vegetables);
                countCereals += getCountOfSoldByGenre(order, ProductType.Cereals);
                countSoftDrinks += getCountOfSoldByGenre(order, ProductType.SoftDrinks);
                countAlcohol += getCountOfSoldByGenre(order, ProductType.Alcohol);

            };
        }
        ;
        ArrayList<ProductAdditional> result = new ArrayList<>();
        result.add(new ProductAdditional(ProductType.Meat, countMeat));
        result.add(new ProductAdditional(ProductType.Fish, countFish));
        result.add(new ProductAdditional(ProductType.Fruits, countFruits));
        result.add(new ProductAdditional(ProductType.MilkProducts, countMilkProducts));
        result.add(new ProductAdditional(ProductType.DessertsAndSweet, countDessertsAndSweet));
        result.add(new ProductAdditional(ProductType.Vegetables, countVegetables));
        result.add(new ProductAdditional(ProductType.Cereals, countCereals));
        result.add(new ProductAdditional(ProductType.SoftDrinks, countSoftDrinks));
        result.add(new ProductAdditional(ProductType.Alcohol, countAlcohol));


        result.sort(new Comparator<ProductAdditional>() {
            @Override
            public int compare(ProductAdditional left, ProductAdditional right) {
                return right.getCount()-left.getCount();
            }
        });
        return result.get(0).getGenre();
    }

    ;

    // количестов продуктов по типу
    public static ArrayList<ProductAdditional> getCountOfSoldProductsByGenre() {
        ArrayList<ProductAdditional> result = new ArrayList<>();
        int countMilkProducts = 0, countDessertsAndSweet = 0, countMeat = 0,
                countFish = 0, countVegetables = 0, countFruits = 0, countCereals = 0,
                countSoftDrinks = 0, countAlcohol = 0;

        for (Order order : orders) {
            countMeat += getCountOfSoldByGenre(order, ProductType.Meat);
            countFish += getCountOfSoldByGenre(order, ProductType.Fish);
            countFruits += getCountOfSoldByGenre(order, ProductType.Fruits);
            countMilkProducts += getCountOfSoldByGenre(order, ProductType.MilkProducts);
            countDessertsAndSweet += getCountOfSoldByGenre(order, ProductType.DessertsAndSweet);
            countVegetables += getCountOfSoldByGenre(order, ProductType.Vegetables);
            countCereals += getCountOfSoldByGenre(order, ProductType.Cereals);
            countSoftDrinks += getCountOfSoldByGenre(order, ProductType.SoftDrinks);
            countAlcohol += getCountOfSoldByGenre(order, ProductType.Alcohol);

        }
        result.add(new ProductAdditional(ProductType.Meat, countMeat));
        result.add(new ProductAdditional(ProductType.Fish, countFish));
        result.add(new ProductAdditional(ProductType.Fruits, countFruits));
        result.add(new ProductAdditional(ProductType.MilkProducts, countMilkProducts));
        result.add(new ProductAdditional(ProductType.DessertsAndSweet, countDessertsAndSweet));
        result.add(new ProductAdditional(ProductType.Vegetables, countVegetables));
        result.add(new ProductAdditional(ProductType.Cereals, countCereals));
        result.add(new ProductAdditional(ProductType.SoftDrinks, countSoftDrinks));
        result.add(new ProductAdditional(ProductType.Alcohol, countAlcohol));

        return result;
    }


    // получить количество продуктов в одном заказе по типу
    public static int getCountOfSoldByGenre(Order order, ProductType genre) {
        int count = 0;

        for (long productId : order.getProducts()) {
            Product product = getProductById(productId);
            if (product != null && product.getGenre() == genre) {
                count++;
            }
        }
        return count;
    }

    // получить общую сумму продуктов в одном заказе по типу
    public static double getPriceOfSoldByGenre(Order order, ProductType genre) {
        double price = 0;

        for (long productId : order.getProducts()) {
            Product product = getProductById(productId);
            if (product != null && product.getGenre() == genre)
                price += product.getPrice();
        }
        return price;
    }


    // получить стоимость проданных продуктов по типам
    public static HashMap<ProductType, Double> getPriceOfSoldProductsByGenre() {
        HashMap<ProductType, Double> result = new HashMap<>();

        double priceMilkProducts = 0, priceDessertsAndSweet = 0, priceMeat = 0,
                priceFish = 0, priceVegetables = 0, priceFruits = 0, priceCereals = 0,
                priceSoftDrinks = 0, priceAlcohol = 0;

        for (Order order : orders) {
            priceMeat += getPriceOfSoldByGenre(order, ProductType.Meat);
            priceFish += getPriceOfSoldByGenre(order, ProductType.Fish);
            priceFruits += getPriceOfSoldByGenre(order, ProductType.Fruits);
            priceMilkProducts += getPriceOfSoldByGenre(order, ProductType.MilkProducts);
            priceDessertsAndSweet += getPriceOfSoldByGenre(order, ProductType.DessertsAndSweet);
            priceVegetables += getPriceOfSoldByGenre(order, ProductType.Vegetables);
            priceCereals += getPriceOfSoldByGenre(order, ProductType.Cereals);
            priceSoftDrinks += getPriceOfSoldByGenre(order, ProductType.SoftDrinks);
            priceAlcohol += getPriceOfSoldByGenre(order, ProductType.Alcohol);

        }

        result.put(ProductType.Meat, priceMeat);
        result.put(ProductType.Fish, priceFish);
        result.put(ProductType.Fruits, priceFruits);
        result.put(ProductType.MilkProducts, priceMilkProducts);
        result.put(ProductType.DessertsAndSweet, priceDessertsAndSweet);
        result.put(ProductType.Vegetables, priceVegetables);
        result.put(ProductType.Cereals, priceCereals);
        result.put(ProductType.SoftDrinks, priceSoftDrinks);
        result.put(ProductType.Alcohol, priceAlcohol);

        return result;
    }


    /**
     * Получить общее количество и стоимость проданных продуктов продавцом id
     *
     *
     * @return
     */
    public static Profit getProfitBySellers(long sellersId) {
        int count = 0;
        double price = 0;
        for (Order order : orders) {
            if (order.getSellersId() == sellersId) {
                price += getPriceOfSoldProductsInOrder(order);
                count += order.getProducts().length;
            }
        }
        return new Profit(count, price);
    }


    /**
     * @param id - номер продукта
     * @return - возвращает найденный продукт
     */

    // get product by Id
    public static Product getProductById(long id) {
        Product current = null;

        for (Product product : products) {
            if (product.getId() == id) {
                current = product;
                break;
            }
        }

        return current;
    }

    // получить все проданные продукты
    public static int getCountOfSoldProducts() {
        int count = 0;

        for (Order order : orders) {
            count = count + order.getProducts().length;
        }
        return count;
    }

    /**
     * получить общую стоимость одного заказа
     *
     * @param order
     * @return
     */
    public static double getPriceOfSoldProductsInOrder(Order order) {
        double price = 0;

        for (long productId : order.getProducts()) {
            Product product = getProductById(productId);
            if (product != null)
                price += product.getPrice();
        }
        return price;
    }

    // получить общую сумму заказов
    public static double getAllPriceOfSoldProducts() {
        double price = 0;
        for (Order order : orders) {
            price += getPriceOfSoldProductsInOrder(order);
        }

        return price;
    }


    public static void Initial() {

        //Продавцы
        sellers.add(new Sellers(1, "Артур", 30));
        sellers.add(new Sellers(2, "Зина", 64));
        sellers.add(new Sellers(3, "Оля", 21));

        //Покупатели
        buyers.add(new Buyers(1, "Паша", 14));
        buyers.add(new Buyers(2, "Вера", 18));
        buyers.add(new Buyers(3, "Варя", 19));
        buyers.add(new Buyers(4, "Олег", 25));
        buyers.add(new Buyers(5, "Семён", 33));
        buyers.add(new Buyers(6, "Руслан", 20));
        buyers.add(new Buyers(7, "Катя", 16));

        //Продукты

        //Молочные продукты
        products.add(new Product(1, "Сметана", "Домик в деревне", 80, ProductType.MilkProducts));
        products.add(new Product(2, "Молоко", "Простоквашино", 60, ProductType.MilkProducts));
        products.add(new Product(3, "Айран", "Кавказский долгожитель", 100, ProductType.MilkProducts));
        products.add(new Product(4, "Кефир", "Ряженка", 40, ProductType.MilkProducts));
        products.add(new Product(5, "Творог", "Домик в деревне", 55, ProductType.MilkProducts));

        //Десерты и сладости
        products.add(new Product(6, "Сникерс", "ООО Импорт", 35.99, ProductType.DessertsAndSweet));
        products.add(new Product(7, "Твикс", "ООО Импорт", 37.99, ProductType.DessertsAndSweet));
        products.add(new Product(8, "Марс", "ООО Импорт", 39.99, ProductType.DessertsAndSweet));
        products.add(new Product(9, "35", "ООО Наше", 34.99, ProductType.DessertsAndSweet));
        products.add(new Product(10, "Красный Мак (кг)", "ООО Наше", 159.99, ProductType.DessertsAndSweet));

        //Мясо
        products.add(new Product(11, "Сосиски Халяль", "Райан", 95.5, ProductType.Meat));
        products.add(new Product(12, "Пельмени Халяль", "Райан", 114.5, ProductType.Meat));
        products.add(new Product(13, "Фарш (кг)", "ООО Джед", 300, ProductType.Meat));
        products.add(new Product(14, "Яица", "ООО Джед (10 шт)", 70, ProductType.Meat));
        products.add(new Product(15, "Колбаса Докторская", "ООО не повезло доктору", 109.99, ProductType.Meat));

        //Рыба
        products.add(new Product(16, "Селёдка", "Домик Рыбака", 75, ProductType.Fish));
        products.add(new Product(17, "Карп", "Домик Рыбака", 250, ProductType.Fish));
        products.add(new Product(18, "Вобла", "ООО Фишер", 200, ProductType.Fish));
        products.add(new Product(19, "Икра Чёрная", "ООО Фишер", 190, ProductType.Fish));
        products.add(new Product(20, "Икра Красная", "ООО Фишер", 230, ProductType.Fish));

        //Овощи
        products.add(new Product(21, "Картошка (кг)", "ООО Всё Своё", 40, ProductType.Vegetables));
        products.add(new Product(22, "Редиска (кг)", "ООО Всё Своё", 50, ProductType.Vegetables));
        products.add(new Product(23, "Помидоры (кг)", "ООО Всё Своё", 80, ProductType.Vegetables));
        products.add(new Product(24, "Огурцы (кг)", "ООО Всё Своё", 75, ProductType.Vegetables));
        products.add(new Product(25, "Картошка", "ООО Всё Своё", 40, ProductType.Vegetables));

        //Фрукты
        products.add(new Product(26, "Яблоки (кг)", "ООО Всё Своё", 70, ProductType.Fruits));
        products.add(new Product(27, "Груши (кг)", "ООО Всё Своё", 70, ProductType.Fruits));
        products.add(new Product(28, "Лимон (шт)", "ООО Всё Своё", 20, ProductType.Fruits));
        products.add(new Product(29, "Вишни (кг)", "ООО Всё Своё", 100, ProductType.Fruits));
        products.add(new Product(30, "Персики (кг)", "ООО Всё Своё", 95, ProductType.Fruits));

        //Крупы
        products.add(new Product(31, "Рис", "Здоровая Страна", 30, ProductType.Cereals));
        products.add(new Product(32, "Овсянка", "Здоровая Страна", 35, ProductType.Cereals));
        products.add(new Product(33, "Кукурузная Крупа", "Здоровая Страна", 37, ProductType.Cereals));
        products.add(new Product(34, "Пшеничная Крупа", "Здоровая Страна", 45, ProductType.Cereals));
        products.add(new Product(35, "Манка", "Здоровая Страна", 39, ProductType.Cereals));

        //Безалкогольные напитки
        products.add(new Product(36, "Кола", "CocaCola", 90, ProductType.SoftDrinks));
        products.add(new Product(37, "Пепси", "PepsiCola", 95, ProductType.SoftDrinks));
        products.add(new Product(38, "Лимонад", "ООО Халвичный завод нальчинский", 25, ProductType.SoftDrinks));
        products.add(new Product(39, "Тархун", "ООО Халвичный завод нальчинский", 30, ProductType.SoftDrinks));
        products.add(new Product(40, "Мохито", "ООО Халвичный завод нальчинский", 35, ProductType.SoftDrinks));

        //Алкоголь
        products.add(new Product(41, "Водка", "ООО Алкаш", 299.9, ProductType.Alcohol));
        products.add(new Product(42, "Вино", "ООО Ценитель", 3799.9, ProductType.Alcohol));
        products.add(new Product(43, "Коньяк", "ООО Ценитель", 2799.9, ProductType.Alcohol));
        products.add(new Product(44, "Чача", "ООО Алкаш", 999.9, ProductType.Alcohol));
        products.add(new Product(45, "Виски", "Propper Twelve", 6799.9, ProductType.Alcohol));

        //Покупки
        orders.add(new Order(1, 1, 1, new long[]{1,5,7,9}));
        orders.add(new Order(2, 2 , 1, new long[]{14, 8, 29, 3, 19}));
        orders.add(new Order(3, 5 , 2, new long[]{45, 36, 19, 20}));
        orders.add(new Order(4, 7 , 3, new long[]{43, 40, 16}));
        orders.add(new Order(5, 3 , 3, new long[]{4, 8, 22}));
        orders.add(new Order(6, 4 , 1, new long[]{44, 38, 18, 33}));
        orders.add(new Order(7, 6 , 2, new long[]{11, 22, 33, 44}));

    }
}
