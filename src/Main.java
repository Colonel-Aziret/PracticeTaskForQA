import java.util.ArrayList;
import java.util.Scanner;

/*                          Программа по складированию товаров
    Цель задачи:
         У нас есть товары разного объема и складские помещения размером 50 кубометров. У каждого
         товара помимо номера и типа есть различные свойства, цвет и т.д. (Потом добавлю список товаров и
         их свойства)
    Подробности о задаче:
        Коробка с шампунями:
            ● type – тип товара тут у нас будет шампунь
            ● name – наименование товара не путать с типом этом может быть “Head & Shoulders”
            ● volume – объем коробки
            ● shampooVolume – объем бутылки шампуня
            ● дальше можете придумать свои поля
        Коробка с мылом:
            ● type – тип товара тут у нас будет шампунь
            ● name – наименование товара не путать с типом этом может быть “ Хозяйственное мыло”
            ● volume – объем коробки
            ● weight – вес мыла
            ● дальше можете придумать свои поля
        Блок с напитка:
            ● type – тип товара тут у нас будет шампунь
            ● name – наименование товара не путать с типом этом может быть “Coca cola”
            ● volume – объем коробки
            ● bottleVolume – объем бутылки шампуня
            ● дальше можете придумать свои поля
            Можете придумать еще товары для работы с программой
                                            Например:
                Из товаров у нас коробки с шампунем объёмом 3 кубометра и коробки с мылом объемом в 4
                кубометра. И три складских помещения размером 50 кубометров.
                Наша цель построить программу что будет сортировать товары по складам.
                Грузовик принёс 30 коробок с шампунем мы загрузили первый склад на 16 коробок (48 кубометров
                из 50). Затем загрузили второй склад на 14 коробок (42 кубометров из 50). На следующий день
                грузовик привёз 25 коробок мыла. Мы заполнили третий склад 12тью коробками мыла (48
                кубометров из 50). Затем закинули 2 коробки мыла во второй склад две коробки (добавили к 42
                кубометрам ещё 8). И так как больше ничего не поместилось программа должна вернуть грузовику
                оставшиеся 11 коробок мыла.
     */

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Warehouse> warehouses = new ArrayList<>();
        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();
        Warehouse warehouse3 = new Warehouse();

        warehouses.add(warehouse1);
        warehouses.add(warehouse2);
        warehouses.add(warehouse3);


        AddNewProduct(warehouses, new ArrayList<Product>());

        ArrayList<Product> products = new ArrayList<>();

        while (true) {
            int mainMenuItem;
            System.out.println("-------------------------------------------------------------");
            System.out.println("Выберите пункт меню:");
            System.out.println("    1) Работа с товарами");
            System.out.println("    2) Работа со складом");
            System.out.println("    0) Выход  из программы");
            System.out.print("Ввод:");
            mainMenuItem = scanner.nextInt();
            if (mainMenuItem == 1) {
                workWithProducts(warehouses, products);
            } else if (mainMenuItem == 2) {
                workWithStorages(warehouses);
            } else if (mainMenuItem == 0) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Выход из программы...");
                break;
            } else {
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    private static void workWithProducts(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        while (true) {
            int mainMenuItem;
            System.out.println("-------------------------------------------------------------");
            System.out.println("Выберите пункт меню в работе с товарами");
            System.out.println("    1) Добавление товара на склад");
            System.out.println("    2) Добавление группы товаров на склад");
            System.out.println("    3) Удаление товара со склада");
            System.out.println("    4) Удаление группы товаров со склада");
            System.out.println("    5) Показать типы товаров и их количество");
            System.out.println("    0) Выход в главное меню");
            System.out.print("Ввод:");
            mainMenuItem = scanner.nextInt();
            if (mainMenuItem == 1) {
                AddingGoodsToTheWarehouse(warehouses, products);
            } else if (mainMenuItem == 2) {
                AddingManyGoodsToTheWarehouse(warehouses, products);
            } else if (mainMenuItem == 3) {

            } else if (mainMenuItem == 4) {

            } else if (mainMenuItem == 5) {
                allProduct(warehouses, products);
            } else if (mainMenuItem == 0) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Выход в предыдущее меню...");
                break;
            }
        }
    }

    private static void workWithStorages(ArrayList<Warehouse> warehouses) {
        while (true) {
            int mainMenuItem;
            System.out.println("-------------------------------------------------------------");
            System.out.println("Выберите пункт меню в работе со складами");
            System.out.println("    1) Показать список складов и товаров в них");
            System.out.println("    2) Добавть новый склад");
            System.out.println("    3) Удалить склад");
            System.out.println("    0) Выход в главное меню");
            System.out.print("Ввод:");
            mainMenuItem = scanner.nextInt();
            if (mainMenuItem == 1) {
                AllStock(warehouses);
            } else if (mainMenuItem == 2) {
                NewStock(warehouses);
            } else if (mainMenuItem == 3) {
                deliteStock(warehouses);
            } else if (mainMenuItem == 0) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Выход в предыдущее меню...");
                break;
            }
        }
    }

    public static void AddingGoodsToTheWarehouse(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        while (true) {
            int mainMenuItem;
            System.out.println("    1) Добавление шампуня на склад");
            System.out.println("    2) Добавление мыло на склад");
            System.out.println("    3) Добавление напитка на склад");
            System.out.println("    0) Выход в главное меню");
            System.out.print("Ввод:");
            mainMenuItem = scanner.nextInt();
            if (mainMenuItem == 1) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Информация о товаре:");
                System.out.println("    1) Введите название Шампуня");
                System.out.print("Ввод:");
                String shampooName = scanner.next();
                System.out.println("    2) Введите объём Шампуня");
                System.out.print("Ввод:");
                int shampooVolume = scanner.nextInt();
                products.add(0, new Product("Шампунь", shampooName, 3, shampooVolume));
                System.out.println(products.get(0).toString());
                break;
            } else if (mainMenuItem == 2) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Информация о товаре:");
                System.out.println("    1) Введите название Мыла");
                System.out.print("Ввод:");
                String soapName = scanner.next();
                System.out.println("    2) Введите вес Мыла");
                System.out.print("Ввод:");
                int soapWeight = scanner.nextInt();
                products.add(0, new Product("Мыло", soapName, 4, soapWeight));
                System.out.println(products.get(0).toString());
                break;
            } else if (mainMenuItem == 3) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Информация о товаре:");
                System.out.println("    1) Введите название Напитка");
                System.out.print("Ввод:");
                String drinkName = scanner.next();
                System.out.println("    2) Введите объём Напитка");
                System.out.print("Ввод:");
                int drinkVolume = scanner.nextInt();
                products.add(0, new Product("Напиток", drinkName, 5, drinkVolume));
                System.out.println(products.get(0).toString());
                break;
            } else if (mainMenuItem == 0) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Выход в предыдущее меню...");
                break;
            } else {
                System.out.println("-------------------------------------------------------------");
            }
            System.out.println("Ошибка. Введите цифру из меню!!!");
        }
        AddNewProduct(warehouses, products);
    }

    public static void AddingManyGoodsToTheWarehouse(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        while (true) {
            int mainMenuItem;
            System.out.println("-------------------------------------------------------------");
            System.out.println("Введите количество коробок для добавления на склад");
            System.out.print("Ввод:");
            int howManyBox = scanner.nextInt();
            System.out.println("-------------------------------------------------------------");
            System.out.println("    1) Добавление шампуня на склад");
            System.out.println("    2) Добавление мыло на склад");
            System.out.println("    3) Добавление напитка на склад");
            System.out.println("    0) Выход в главное меню");
            System.out.print("Ввод:");
            mainMenuItem = scanner.nextInt();
            if (mainMenuItem == 1) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Информация о товаре:");
                System.out.println("    1) Введите название Шампуня");
                System.out.print("Ввод:");
                String shampooName = scanner.next();
                System.out.println("    2) Введите объём Шампуня");
                System.out.print("Ввод:");
                int shampooVolume = scanner.nextInt();
                for (int i = 0; i < howManyBox; i++) {
                    products.add(0, new Product("Шампунь", shampooName, 3, shampooVolume));
                    System.out.println(products.get(0).toString());
                }
                break;
            } else if (mainMenuItem == 2) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Информация о товаре:");
                System.out.println("    1) Введите название Мыла");
                System.out.print("Ввод:");
                String soapName = scanner.next();
                System.out.println("    2) Введите вес Мыла");
                System.out.print("Ввод:");
                int soapWeight = scanner.nextInt();
                for (int i = 0; i < howManyBox; i++) {
                    products.add(0, new Product("Мыло", soapName, 4, soapWeight));
                    System.out.println(products.get(0).toString());
                }
                break;
            } else if (mainMenuItem == 3) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Информация о товаре:");
                System.out.println("    1) Введите название Напитка");
                System.out.print("Ввод:");
                String drinkName = scanner.next();
                System.out.println("    2) Введите объём Напитка");
                System.out.print("Ввод:");
                int drinkVolume = scanner.nextInt();
                for (int i = 0; i < howManyBox; i++) {
                    products.add(0, new Product("Напиток", drinkName, 5, drinkVolume));
                    System.out.println(products.get(0).toString());
                }
                break;
            } else if (mainMenuItem == 0) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Выход в предыдущее меню...");
                break;
            } else {
                System.out.println("-------------------------------------------------------------");
            }
            System.out.println("Ошибка. Введите цифру из меню!!!");
        }
        AddNewProduct(warehouses, products);
    }


    private static void AllStock(ArrayList<Warehouse> warehouses) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Информация о всех Складах:");
        for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse.toString());
        }
    }

    private static void deliteStock(ArrayList<Warehouse> warehouses) {
        warehouses.remove(0);
        AddNewProduct(warehouses, new ArrayList<Product>());
        System.out.println("-------------------------------------------------------------");
        System.out.println("Один склад был удалён");
    }

    private static void NewStock(ArrayList<Warehouse> warehouses) {
        Warehouse warehouse3 = new Warehouse();
        warehouses.add(warehouse3);
        AddNewProduct(warehouses, new ArrayList<Product>());
        System.out.println("-------------------------------------------------------------");
        System.out.println("Один склад был добавлен");
    }

    public static void AddNewProduct(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        for (Warehouse warehouse : warehouses) {
            ArrayList<Product> productsInStock = new ArrayList<>();
            ArrayList<Product> productsInUse = new ArrayList<>();
            for (Product p : products) {
                if ((warehouse.getVolume() > p.getVolumeBox()) && !productsInUse.contains(p)) {
                    warehouse.setVolume(warehouse.getVolume() - p.getVolumeBox());
                    productsInStock.add(p);
                    productsInUse.add(p);
                } else {
                    break;
                }
            }
            warehouse.setProducts(productsInStock);
            productsInStock = new ArrayList<>();
        }
    }

    public static void allProduct(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        int counterShampoo = 0;
        int counterSoap = 0;
        int counterdrink = 0;
        for (Product product : products) {
            if (product.getType().equals("Шампунь")) {
                counterShampoo++;
            } else if (product.getType().equals("Мыло")) {
                counterSoap++;
            } else if (product.getType().equals("Напиток")) {
                counterdrink++;
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Все товары со всех складов");
        System.out.println("Коробки с шампунем " + counterShampoo + " товара(ов)");
        System.out.println("Коробки с мылом " + counterSoap + " товара(ов)");
        System.out.println("Блок c напитком " + counterdrink + " товара(ов)");
    }
}