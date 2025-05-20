import task1.Product;
import task1.ProductDB;
import task2.DaysOfWeek;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        task2();
//        task1Test();
        task1();
    }

    public static final String fileName = "productDB.txt";

    public static Product inputProduct(Scanner scanner) {
        String name, category;
        double price;
        int quantity;

        System.out.println("Enter product name: ");
        name = scanner.nextLine();
        System.out.println("Enter product category: ");
        category = scanner.nextLine();
        System.out.println("Enter product price: ");
        price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter product quantity: ");
        quantity = Integer.parseInt(scanner.nextLine());

        return new Product(name, category, price, quantity);
    }

    public static void task1() {
        ProductDB productDB = new ProductDB();

        try {
            FileInputStream fileInputStream = new FileInputStream (Main.fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productDB = (ProductDB) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Unable to read productDB.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String command = "";
        Scanner scanner = new Scanner(System.in);

        MainLoop:
        while (true) {
            System.out.println("----------");
            System.out.println("a, add : Add a product");
            System.out.println("ri, removeId : Remove a product by id");
            System.out.println("rn, removeName : Remove a product by name");
            System.out.println("p, print : print product details");
            System.out.println("t, top : get top 5 products by quantity");
            System.out.println("c, count : products count by category");
            System.out.println("pdb, printDB : print productDB");
            System.out.println("e, exit : exit from program");
            System.out.println("----------");
            System.out.println("Enter command: ");

            command = scanner.nextLine();
            switch (command) {
                case "a":
                case "add":
                    productDB.addProduct(inputProduct(scanner));
                    break;
                case "ri":
                case "removeId":
                    System.out.println("Enter product id: ");
                    productDB.removeProductByID(Integer.parseInt(scanner.nextLine()));
                    break;
                case "rn":
                case "removeName":
                    System.out.println("Enter product name: ");
                    productDB.removeProductByName(scanner.nextLine());
                    break;
                case "p":
                case "print":
                    System.out.println("Enter product id: ");
                    productDB.printDetails(Integer.parseInt(scanner.nextLine()));
                    break;
                case "t":
                case "top":
                    productDB.getTop5Products().forEach(System.out::println);
                    break;
                case "c":
                case "count":
                    productDB.productsCountByCategory();
                    break;
                case "pdb":
                case "printDB":
                    System.out.println(productDB);
                    break;
                case "q":
                case "e":
                case "exit":
                    break MainLoop;
            }
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Main.fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productDB);
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void task1Test() {
        ProductDB productDB = new ProductDB();
        List<Product> products = new ArrayList<>();
        products.add(new Product("lays", "chips", 1.65d, 16));
        products.add(new Product("fanta", "drink", 1.65d, 4));
        products.add(new Product("cocacola", "drink", 1.7d, 20));
        productDB.sort(products);

        System.out.println("Sorted products: ");
        System.out.println(productDB);

        productDB.addProduct(new Product("for delete", "test", 9.45d, 1));
        System.out.println("Add Product: ");
        System.out.println(productDB);

        System.out.println("Top 5 Products: ");
        List<Product> top5Products = productDB.getTop5Products();
        for (int i = 0; i < top5Products.size(); i++) {
            System.out.println((i + 1) + ". " + top5Products.get(i));
        }

        System.out.println("Products Count By Category: ");
        productDB.productsCountByCategory();

        productDB.removeProductByName("for delete");
        System.out.println("Remove Product: ");
        System.out.println(productDB);


        System.out.println("Product ID 1: ");
        productDB.printDetails(1);

    }

    public static void task2() {
        DaysOfWeek day = DaysOfWeek.MONDAY;
        DaysOfWeek nextDay = day.getNextDay();
        DaysOfWeek previousDay = day.getPreviousDay();

        System.out.println("Day: " + day + " Short Value: " + day.shortValue + " is weekend: " + day.isWeekend());
        System.out.println("Next Day: " + nextDay + " is weekend: " + nextDay.isWeekend());
        System.out.println("Prev Day: " + previousDay + " is weekend: " + previousDay.isWeekend());

        System.out.println("Describe Day: ");
        DaysOfWeek.describeDay(day);

        System.out.println("Week Days: ");
        DaysOfWeek.printWeekdays();

        System.out.println("Weekend Days: ");
        DaysOfWeek.printWeekends();
    }

}