package service.impl;

import entity.Product;
import entity.User;
import service.ProductService;
import service.Staff;
import service.UserService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Manager implements Staff {
    @Override
    public boolean check_in() {
        return false;
    }

    @Override
    public boolean check_out() {
        return false;
    }

    @Override
    public boolean confirmOrderFromCustomer() {
        return false;
    }

    @Override
    public void createShipment() {

    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=====WELCOME MANAGER=====");
            System.out.println("Please select an option:");
            System.out.println("1. Check-in Product");
            System.out.println("2. Check-out Product");
            System.out.println("3. Confirm order from Customer");
            System.out.println("4. Create shipment");
            System.out.println("5. Register for staff");
            System.out.println("6. Add product");
            System.out.println("7. Update product");
            System.out.println("8. Delete product");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("=====REGISTER=====");
                    System.out.println("Input User Name: ");
                    String userName = sc.next();
                    System.out.println("Input password: ");
                    String password = sc.next();
                    System.out.println("Input email: ");
                    String email = sc.next();
                    System.out.println("Input role: ");
                    String role = sc.next();
                    if (UserService.register(email, userName, password,role)) {
                        User user = new User(email, userName, password, role);
                        UserService.userList.add(user);
                        UserService.saveUser();
                        break;
                    } else {
                        System.err.println("Enter again");
                    }
                    break;
                case 6:
                    System.out.println("=====ADD PRODUCT=====");
                    System.out.println("Input product's ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Input product's name: ");
                    String productName = sc.nextLine();

                    System.out.println("Input quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Input unit price of product: ");
                    int unitOfProduct = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Input manufacture date of product: ");
                    String manufactureDate = sc.nextLine();

                    System.out.println("Input expiration date of product: ");
                    String expirationDate = sc.nextLine();

                    System.out.println("Input unit of product: ");
                    String unit = sc.nextLine();

                    System.out.println("Input description of product: ");
                    String description = sc.nextLine();
                    Product newProduct = new Product(id,productName,quantity,unitOfProduct,manufactureDate,expirationDate,unit,description);
                    ProductService.addProduct(newProduct);
                    break;
                case 7:
                    System.out.println("=====UPDATE PRODUCT=====");
                    System.out.println("Input product's name: ");
                    sc.nextLine();
                    productName = sc.nextLine();
                    List<Product> productList7 = ProductService.loadProductFromFile();
                    if (ProductService.findProductByName(productName,productList7)){
                        try {
                            System.out.println("Input product's ID: ");
                            int idUpdate = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Input product's name: ");
                            String productNameUpdate = sc.nextLine();

                            System.out.println("Input quantity: ");
                            int quantityUpdate = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Input unit price of product: ");
                            int unitOfProductUpdate = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Input manufacture date of product: ");
                            String manufactureDateUpdate = sc.nextLine();

                            System.out.println("Input expiration date of product: ");
                            String expirationDateUpdate = sc.nextLine();

                            System.out.println("Input unit of product: ");
                            String unitUpdate = sc.nextLine();

                            System.out.println("Input description of product: ");
                            String descriptionUpdate = sc.nextLine();

                            Product updateProduct = new Product(idUpdate, productNameUpdate, quantityUpdate, unitOfProductUpdate, manufactureDateUpdate, expirationDateUpdate, unitUpdate, descriptionUpdate);
                            ProductService.updateProduct(productName, updateProduct, productList7);
                        } catch (Exception e){
                            System.err.println("Nhập lại cho đúng đi má !!!");
                        }
                    } else {
                        System.err.println("Product not found!!!");
                    }
                    break;
                case 8:
                    System.out.println("=====REMOVE PRODUCT=====");
                    System.out.println("Input product's name: ");
                    sc.nextLine();
                    productName = sc.nextLine();
                    List<Product> productList8 = ProductService.loadProductFromFile();
                    if (ProductService.findProductByName(productName, productList8)) {
                        ProductService.deleteProductByName(productName, productList8);
                    } else {
                        System.err.println("Product not found");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Invalid choice!!!");
            }
        } while (true);
    }
}
