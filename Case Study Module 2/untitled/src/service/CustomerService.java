package service;

import entity.Customer;
import entity.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService extends Customer {
    private static final String ORDER_HISTORY_FILE = "C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\orderHistory.csv";
    public static void viewProducts (){
        try {
            FileReader fileReader = new FileReader("C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\dataProduct.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void orderProduct(String productName, int quantity, LocalDate orderDate, String destination, String message) {
        List<Product> productList = ProductService.loadProductFromFile();
        Product product = ProductService.findProductByName1(productName, productList);
        boolean isDelivered = false;
        if (product == null) {
            System.err.println("Product does not exist!!!");
            return;
        }

        if (quantity <= 0) {
            System.err.println("Invalid quantity!!!");
            return;
        } else if (quantity > product.getQuantity()) {
            System.err.println("Does not have enough products!!!");
            return;
        }

        Order order = new Order(productName,quantity,LocalDate.now(),destination,message,isDelivered);
        ordersHistory.add(order);

        boolean isAccepted = false;
        OrderResponse orderResponse = new OrderResponse(isAccepted,message,isDelivered);

        product.setQuantity(product.getQuantity() - quantity);

        if (orderResponse.isDelivered()) {
            ProductService.loadProductFromFile();
        } else {
            System.out.println("Order has not been delivered yet!");
        }

        try {
            FileWriter fileWriter = new FileWriter(ORDER_HISTORY_FILE, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(order.toFile());
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Order successfully");
    }

    public static void viewHistoryOrder() {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\orderHistory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isLocalDate(Object obj) {
        return obj instanceof LocalDate;
    }

    public static List<Order> loadOrderListFromFile() {
        List<Order> orderList = new ArrayList<>();
        Path filePath = Paths.get(ORDER_HISTORY_FILE);

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                String[] orderData = line.split(",");

                if (orderData.length == 7) {
                    String orderID = orderData[0];
                    String productName = orderData[1];
                    int quantity = Integer.parseInt(orderData[2]);
                    LocalDate orderDate = LocalDate.parse(orderData[3]);
                    String destination = orderData[4];
                    String message = orderData[5];
                    boolean isDelivered = Boolean.parseBoolean(orderData[6]);

                    Order order = new Order(orderID, productName, quantity, orderDate, destination, message, isDelivered);
                    orderList.add(order);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orderList;
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=====WELCOME CUSTOMER=====");
            System.out.println("1. Create order");
            System.out.println("2. View history order");
            System.out.println("3. Confirm product arrived");
            System.out.println("0. Sign out");
            System.out.println("Your choice: ");
            choice =sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("=====CREATE ORDER=====");
                    viewProducts();
                    System.out.println("Input product's name: ");
                    sc.nextLine();
                    String productName = sc.nextLine();
                    System.out.println("Input quantity: ");
                    int quantity = sc.nextInt();
                    System.out.println("Input destination: ");
                    sc.nextLine();
                    String destination = sc.nextLine();
                    System.out.println("Input message");
                    String message = sc.nextLine();
                    orderProduct(productName,quantity,LocalDate.now(), destination, message);
                    break;
                case 2:
                    viewHistoryOrder();
                    break;
                case 3:
                    break;
                case 0:
                    UserService.run();
                    break;
            }
        } while (true);
    }
}
