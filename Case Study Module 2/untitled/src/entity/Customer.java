package entity;

import service.Order;
import service.OrderResponse;
import service.ProductService;
import service.UserService;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;

import static service.ProductService.isInteger;

public class Customer {
    private static final String ORDER_HISTORY_FILE = "C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\orderHistory.txt";
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String emailOfCustomer;
    public static List<Order> ordersHistory = new ArrayList<>();

    public Customer() {
    }

    public Customer(String customerName, String customerAddress, String customerPhoneNumber, String emailOfCustomer) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.emailOfCustomer = emailOfCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getEmailOfCustomer() {
        return emailOfCustomer;
    }

    public void setEmailOfCustomer(String emailOfCustomer) {
        this.emailOfCustomer = emailOfCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", emailOfCustomer='" + emailOfCustomer + '\'' +
                '}';
    }

    public String toFile() {
        return customerName + "," + customerAddress + "," + customerPhoneNumber + "," + emailOfCustomer;
    }

    public static void viewProducts (){
        try {
            FileReader fileReader = new FileReader("C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\dataProduct.txt");
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
            FileReader fileReader = new FileReader("C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\orderHistory.txt");
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

    public static List<Order> loadOrderHistoryFromFile() {
        Path filePath = Paths.get("C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\orderHistory.txt");
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String[] orderData = line.split(",");
                if (orderData.length != 6) {
                    System.out.println(line);
                    continue;
                }
                try {
                    Order order = new Order(
                            orderData[0],
                            orderData[1],
                            Integer.parseInt(orderData[2]),
                            LocalDate.parse(orderData[3]),
                            orderData[4],
                            orderData[5],
                            Boolean.parseBoolean(orderData[6])
                    );
                    ordersHistory.add(order);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordersHistory;
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