import java.util.ArrayList;
import java.util.Scanner;

public class Launch {
    private static final Scanner scanner = new Scanner(System.in);

    public static void Launch() {
        ArrayList<Warehouse> warehouses = new ArrayList<>();
        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();
        Warehouse warehouse3 = new Warehouse();

        warehouses.add(warehouse1);
        warehouses.add(warehouse2);
        warehouses.add(warehouse3);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> productsInUse = new ArrayList<>();

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
                workWithProducts(warehouses, products, productsInUse);
            } else if (mainMenuItem == 2) {
                workWithStorages(warehouses, products, productsInUse);
            } else if (mainMenuItem == 0) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Выход из программы...");
                break;
            } else {
                System.out.println("-------------------------------------------------------------");
            }
        }
    }


    private static void workWithProducts(ArrayList<Warehouse> warehouses, ArrayList<Product> products, ArrayList<Product> productsInUse) {
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
                AddingGoodsToTheWarehouse(warehouses, products, productsInUse);
            } else if (mainMenuItem == 2) {
                AddingManyGoodsToTheWarehouse(warehouses, products, productsInUse);
            } else if (mainMenuItem == 3) {
                DeletingOneProduct(warehouses, products, productsInUse);
            } else if (mainMenuItem == 4) {
                DeletingManyProduct(warehouses, products, productsInUse);
            } else if (mainMenuItem == 5) {
                allProduct(products);
            } else if (mainMenuItem == 0) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Выход в предыдущее меню...");
                break;
            } else {
                System.out.println("-------------------------------------------------------------");
            }
        }
    }


    private static void workWithStorages(ArrayList<Warehouse> warehouses, ArrayList<Product> products, ArrayList<Product> productsInUse) {
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
                AllStock(warehouses, products);
            } else if (mainMenuItem == 2) {
                NewStock(warehouses, products);
            } else if (mainMenuItem == 3) {
                deleteStock(warehouses, products, productsInUse);
            } else if (mainMenuItem == 0) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Выход в предыдущее меню...");
                break;
            } else {
                System.out.println("-------------------------------------------------------------");
            }
        }
    }


    private static void DeletingManyProduct(ArrayList<Warehouse> warehouses, ArrayList<Product> products, ArrayList<Product> productsInUse) {
        int howManyProductForDelete;
        System.out.println("Введите количество продуктов для удоления");
        System.out.print("Ввод: ");
        howManyProductForDelete = scanner.nextInt();
        while (true) {
            int mainMenuItem;
            System.out.println("-------------------------------------------------------------");
            System.out.println("Выберите продукт для удаления");
            System.out.println("    1) Шампуня");
            System.out.println("    2) Мыло");
            System.out.println("    3) Напитка");
            System.out.println("    0) Выход в предыдущее меню");
            System.out.print("Ввод: ");
            mainMenuItem = scanner.nextInt();

            if (mainMenuItem == 1) {
                for (int i = 0; i < howManyProductForDelete; i++) {
                    for (Product product : products) {
                        if (product.getType().equals("Шампунь")) {
                            products.remove(product);
                            for (Warehouse warehouse : warehouses) {
                                if (warehouse.getVolume() < 45) {
                                    warehouse.setVolume(warehouse.getVolume() + product.getVolumeBox());
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            break;
                        } else {
                            System.out.println("На складе нет этого продукта");
                        }
                    }
                }
                System.out.println(howManyProductForDelete + " продуктов шампуня было удалено");
                break;
            } else if (mainMenuItem == 2) {
                for (int i = 0; i < howManyProductForDelete; i++) {
                    for (Product product : products) {
                        if (product.getType().equals("Мыло")) {
                            products.remove(product);
                            for (Warehouse warehouse : warehouses) {
                                if (warehouse.getVolume() < 45) {
                                    warehouse.setVolume(warehouse.getVolume() + product.getVolumeBox());
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            break;
                        } else {
                            System.out.println("На складе нет этого продукта");
                        }
                    }
                }
                System.out.println(howManyProductForDelete + " продуктов мыла было удалено");
                break;
            } else if (mainMenuItem == 3) {
                for (int i = 0; i < howManyProductForDelete; i++) {
                    for (Product product : products) {
                        if (product.getType().equals("Напиток")) {
                            products.remove(product);
                            for (Warehouse warehouse : warehouses) {
                                if (warehouse.getVolume() < 45) {
                                    warehouse.setVolume(warehouse.getVolume() + product.getVolumeBox());
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            break;
                        } else {
                            System.out.println("На складе нет этого продукта");
                        }
                    }
                }
                System.out.println(howManyProductForDelete + " продуктов напитка было удалено");
                break;
            } else if (mainMenuItem == 0) {
                break;
            } else {
                System.out.println("-------------------------------------------------------------");
            }
        }
        AddNewProduct(warehouses, products, productsInUse);
    }


    private static void DeletingOneProduct(ArrayList<Warehouse> warehouses, ArrayList<Product> products, ArrayList<Product> productsInUse) {
        while (true) {
            int mainMenuItem;
            System.out.println("-------------------------------------------------------------");
            System.out.println("Выберите один продукт для удаления");
            System.out.println("    1) Шампуня");
            System.out.println("    2) Мыло");
            System.out.println("    3) Напитка");
            System.out.println("    0) Выход в предыдущее меню");
            System.out.print("Ввод: ");
            mainMenuItem = scanner.nextInt();

            if (mainMenuItem == 1) {
                for (Product product : products) {
                    if (product.getType().equals("Шампунь")) {
                        products.remove(product);
                        for (Warehouse warehouse : warehouses) {
                            if (warehouse.getVolume() < 45) {
                                warehouse.setVolume(warehouse.getVolume() + product.getVolumeBox());
                                break;
                            } else {
                                continue;
                            }
                        }
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("Продукт шампунь был удалён");
                        break;
                    } else {
                        System.out.println("На складе нет этого продукта");
                    }
                }
                break;
            } else if (mainMenuItem == 2) {
                for (Product product : products) {
                    if (product.getType().equals("Мыло")) {
                        products.remove(product);
                        for (Warehouse warehouse : warehouses) {
                            if (warehouse.getVolume() < 45) {
                                warehouse.setVolume(warehouse.getVolume() + product.getVolumeBox());
                                break;
                            } else {
                                continue;
                            }
                        }
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("Продукт мыло был удалён");
                        break;
                    } else {
                        System.out.println("На складе нет этого продукта");
                    }
                }
                break;
            } else if (mainMenuItem == 3) {
                for (Product product : products) {
                    if (product.getType().equals("Напиток")) {
                        products.remove(product);
                        for (Warehouse warehouse : warehouses) {
                            if (warehouse.getVolume() < 45) {
                                warehouse.setVolume(warehouse.getVolume() + product.getVolumeBox());
                                break;
                            } else {
                                continue;
                            }
                        }
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("Продукт напиток был удалён");
                        break;
                    } else {
                        System.out.println("На складе нет этого продукта");
                    }
                }
                break;
            } else if (mainMenuItem == 0) {
                break;
            } else {
                System.out.println("-------------------------------------------------------------");
            }
        }
        AddNewProduct(warehouses, products, productsInUse);
    }


    public static void AddingGoodsToTheWarehouse(ArrayList<Warehouse> warehouses, ArrayList<Product> products, ArrayList<Product> productsInUse) {
        while (true) {
            int mainMenuItem;
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
        AddNewProduct(warehouses, products, productsInUse);
    }


    public static void AddingManyGoodsToTheWarehouse(ArrayList<Warehouse> warehouses, ArrayList<Product> products, ArrayList<Product> productsInUse) {
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
        AddNewProduct(warehouses, products, productsInUse);
    }


    private static void AllStock(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        int count = 1;
        System.out.println("-------------------------------------------------------------");
        System.out.println("Информация о всех Складах:");
        for (Warehouse warehouse : warehouses) {
            System.out.println("-------------------------------------------------------------");
            System.out.println(warehouse.toString(count));
            try {
                warehouse.ProductMessage();
            } catch (NullPointerException e) {
                System.out.println("Склад пустой");
            }
            count++;
        }
    }


    private static void deleteStock(ArrayList<Warehouse> warehouses, ArrayList<Product> products, ArrayList<Product> productsInUse) {
        warehouses.remove(0);
        AddNewProduct(warehouses, products, productsInUse);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Один склад был удалён");
    }


    private static void NewStock(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        Warehouse warehouse3 = new Warehouse();
        warehouses.add(warehouse3);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Один склад был добавлен");
    }


    public static void AddNewProduct(ArrayList<Warehouse> warehouses, ArrayList<Product> products, ArrayList<Product> productsInUse) {
        ArrayList<Product> productsInStock = new ArrayList<>();
        for (Product p : products) {
            for (Warehouse warehouse : warehouses) {
                if ((warehouse.getVolume() >= p.getVolumeBox()) && !productsInUse.contains(p)) {
                    warehouse.setVolume(warehouse.getVolume() - p.getVolumeBox());
                    warehouse.products1.add(p);
                    productsInStock.add(p);
                    productsInUse.add(p);
                } else {
                    continue;
                }
                warehouse.setProducts(productsInStock);
                productsInStock = new ArrayList<>();
            }
        }
    }


    public static void allProduct(ArrayList<Product> products) {
        int counterShampoo = 0;
        int counterSoap = 0;
        int counterDrink = 0;
        for (Product product : products) {
            switch (product.getType()) {
                case "Шампунь" -> counterShampoo++;
                case "Мыло" -> counterSoap++;
                case "Напиток" -> counterDrink++;
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Все товары со всех складов");
        System.out.println("Коробки с шампунем " + counterShampoo + " товара(ов)");
        System.out.println("Коробки с мылом " + counterSoap + " товара(ов)");
        System.out.println("Блок c напитком " + counterDrink + " товара(ов)");
    }
}
