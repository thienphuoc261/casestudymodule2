package entity;
import service.CustomerService;
import service.Order;
import service.ProductService;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class Employee {

    public static void run(){
        try {
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("=====WELCOME EMPLOYEE=====");
                System.out.println("Please select an option:");
                System.out.println("1. Import Product");
                System.out.println("2. Export Product");
                System.out.println("3. Confirm order from Customer");
                System.out.println("4. Create shipment");
                System.out.println("0. Exit");
                System.out.print("Your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("=====IMPORT PRODUCT=====");
                        ProductService.viewProducts();
                        System.out.println("Input product's ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Input product's name: ");
                        String productName = sc.nextLine();

                        System.out.println("Input quantity: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Input unit price of product: ");
                        int unitPriceOfProduct = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Input manufacture date of product: ");
                        String manufactureDate = sc.nextLine();

                        System.out.println("Input expiration date of product: ");
                        String expirationDate = sc.nextLine();

                        System.out.println("Input unit of product: ");
                        String unit = sc.nextLine();

                        System.out.println("Input description of product: ");
                        String description = sc.nextLine();

                        System.out.println("Input importer: ");
                        String importer = sc.nextLine();

                        System.out.println("Input import date: ");
                        String importDate = sc.nextLine();
                        Product newProduct = new Product(id, productName, quantity, unitPriceOfProduct, manufactureDate, expirationDate, unit, description, importer, importDate);
                        ProductService.importProduct(newProduct);
                        ProductService.noteHistoryImport(productName, description, quantity, unitPriceOfProduct, importer, "IMPORT");
                        break;
                    case 2:
                        System.out.println("=====EXPORT PRODUCT=====");
                        ProductService.viewProducts();
                        System.out.println("Input product's ID: ");
                        int idExport = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Input product's name: ");
                        String productNameExport = sc.nextLine();

                        System.out.println("Input export quantity");
                        int quantityExport = sc.nextInt();

                        System.out.println("Input unit price of product: ");
                        int unitPriceOfProductExport = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Input exporter: ");
                        String exporter = sc.nextLine();

                        ProductService.exportProduct(productNameExport, quantityExport, idExport);
                        ProductService.noteHistoryExport(productNameExport, quantityExport, unitPriceOfProductExport, exporter, "EXPORT");
                        break;
                    case 3:
                        System.out.println("=====ORDER HISTORY===== ");
                        List<Order> orderList = CustomerService.loadOrderListFromFile();
                        CustomerService.exportUndeliveredOrders(orderList);
                        System.out.println("=====PRODUCT LIST=====");
                        ProductService.viewProducts();

                        System.out.println("Input product's ID: ");
                        int productID = sc.nextInt();

                        System.out.println("Input product's name: ");
                        sc.nextLine();
                        String productName1 = sc.nextLine();

                        System.out.println("Input quantity: ");
                        int quantity1 = sc.nextInt();

                        System.out.println("Input unit price of product: ");
                        int unitPriceOfProduct1 = sc.nextInt();

                        System.out.println("Input staff: ");
                        sc.nextLine();
                        String staff = sc.nextLine();

                        ProductService.exportProduct(productName1, quantity1, productID);
                        ProductService.noteHistoryExport(productName1, quantity1, unitPriceOfProduct1, staff, "EXPORT");

                        System.out.println("Input order ID: ");
                        String orderID = sc.nextLine();
                        ProductService.updateOrderStatus(orderID);
                        break;
                    case 4:
                        break;
                    case 0:
                        UserService.run();
                        break;
                    default:
                        System.err.println("Invalid choice!!!");
                }
            } while (true);
        } catch (Exception e){
            System.err.println("Invalid input!!!");
        }
    }
}
