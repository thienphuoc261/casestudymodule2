package entity;

import service.*;
import service.impl.BuiderProduct;
import service.impl.BuilderProvider;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Manager {

    public static void run() {
        try {
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("=====WELCOME MANAGER=====");
                System.out.println("Please select an option:");
                System.out.println("1. Confirm order from Customer");
                System.out.println("2. Create shipment");
                System.out.println("3. Register for staff");
                System.out.println("4. Product service");
                System.out.println("5. Provider service");
                System.out.println("6. Set role");
                System.out.println("7. Export report");
                System.out.println("0. Sign out");
                System.out.print("Your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("=====ORDER HISTORY===== ");
                        List<Order> orderList = CustomerService.loadOrderListFromFile();
                        CustomerService.exportUndeliveredOrders(orderList);
                        System.out.println("=====PRODUCT LIST=====");
                        ProductService.viewProducts();

                        System.out.println("Input product's ID: ");
                        int productID = sc.nextInt();

                        System.out.println("Input product's name: ");
                        sc.nextLine();
                        String productName = sc.nextLine();

                        System.out.println("Input quantity: ");
                        int quantity = sc.nextInt();

                        System.out.println("Input unit price of product: ");
                        int unitPriceOfProduct = sc.nextInt();

                        System.out.println("Input staff: ");
                        sc.nextLine();
                        String staff = sc.nextLine();

                        ProductService.exportProduct(productName, quantity, productID);
                        ProductService.noteHistoryExport(productName, quantity, unitPriceOfProduct, staff, "EXPORT");

                        System.out.println("Input order ID: ");
                        String orderID = sc.nextLine();
                        ProductService.updateOrderStatus(orderID);
                        break;
                    case 3:
                        System.out.println("=====REGISTER=====");
                        System.out.println("Input User Name: ");
                        String userName = sc.next();
                        System.out.println("Input password: ");
                        String password = sc.next();
                        System.out.println("Input email: ");
                        String email = sc.next();
                        System.out.println("Input role: ");
                        String role = sc.next();

                        if (UserService.register(email, userName, password, role)) {
                            User user = new User(email, userName, password, role);
                            UserService.userList.add(user);
                            UserService.saveUser();
                            break;
                        } else {
                            System.err.println("Enter again");
                        }
                        break;
                    case 4:
                        System.out.println("=====PRODUCT SERVICE=====");
                        System.out.println("1. Import product");
                        System.out.println("2. Export product");
                        System.out.println("3. Update product");
                        System.out.println("4. Delete product");
                        System.out.println("5. View products");
                        System.out.println("6. Find product by ID");
                        System.out.println("7. View history of import");
                        System.out.println("8. View history of export");
                        System.out.println("0. Back");
                        System.out.println("Input your choice: ");
                        int choiceProduct = sc.nextInt();

                        switch (choiceProduct) {
                            case 1:
                                System.out.println("=====IMPORT PRODUCT=====");
                                System.out.println("Input product's ID: ");
                                int id = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Input product's name: ");
                                String importProductName = sc.nextLine();

                                System.out.println("Input quantity: ");
                                int importQuantity = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Input unit price of product: ");
                                int unitPriceOfProductImport = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Input manufacture date of product: ");
                                String manufactureDate = sc.nextLine();

                                System.out.println("Input expiration date of product: ");
                                String expirationDate = sc.nextLine();

                                System.out.println("Input unit of product: ");
                                String unit = sc.nextLine();

                                System.out.println("Input description of product: ");
                                String discription = sc.nextLine();

                                System.out.println("Input importer: ");
                                String importer = sc.nextLine();

                                System.out.println("Input import date: ");
                                String importDate = sc.nextLine();
                                Product newProduct = new BuiderProduct()
                                        .buildID(id)
                                        .buildProductName(importProductName)
                                        .buildQuantity(importQuantity)
                                        .buildUnitPriceOfProduct(unitPriceOfProductImport)
                                        .buildManufactureDate(manufactureDate)
                                        .buildExpirationDate(expirationDate)
                                        .buildUnit(unit)
                                        .buildDiscription(discription)
                                        .buildImporter(importer)
                                        .buildImportDate(importDate)
                                        .build();
                                ProductService.importProduct(newProduct);
                                ProductService.noteHistoryImport(importProductName, discription, importQuantity, unitPriceOfProductImport, importer, "IMPORT");
                                break;
                            case 2:
                                System.out.println("=====EXPORT PRODUCT=====");
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

                                System.out.println("Input description of product: ");
                                String descriptionExport = sc.nextLine();

                                System.out.println("Input exporter: ");
                                String exporter = sc.nextLine();

                                ProductService.exportProduct(productNameExport, quantityExport, idExport);
                                ProductService.noteHistoryExport(productNameExport, quantityExport, unitPriceOfProductExport, exporter, "EXPORT");
                                break;
                            case 3:
                                System.out.println("=====UPDATE PRODUCT=====");
                                System.out.println("Input product's name: ");
                                sc.nextLine();
                                productName = sc.nextLine();
                                List<Product> productListForUpdate = ProductService.loadProductFromFile();
                                if (ProductService.findProductByName(productName, productListForUpdate)) {
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

                                        System.out.println("Input update importer: ");
                                        String importerUpdate = sc.nextLine();

                                        System.out.println("Input update import date: ");
                                        String importDateUpdate = sc.nextLine();

//                                        Product updateProduct = new Product(idUpdate, productNameUpdate, quantityUpdate, unitOfProductUpdate, manufactureDateUpdate, expirationDateUpdate, unitUpdate, descriptionUpdate, importerUpdate, importDateUpdate);
                                        Product updateProduct = new BuiderProduct()
                                                .buildID(idUpdate)
                                                .buildProductName(productNameUpdate)
                                                .buildQuantity(quantityUpdate)
                                                .buildUnitPriceOfProduct(unitOfProductUpdate)
                                                .buildManufactureDate(manufactureDateUpdate)
                                                .buildExpirationDate(expirationDateUpdate)
                                                .buildUnit(unitUpdate)
                                                .buildDiscription(descriptionUpdate)
                                                .buildImporter(importerUpdate)
                                                .buildImportDate(importDateUpdate)
                                                .build();
                                        ProductService.updateProduct(productName, updateProduct, productListForUpdate);
                                    } catch (Exception e) {
                                        System.err.println("Nhập lại cho đúng đi má !!!");
                                    }
                                } else {
                                    System.err.println("Product not found!!!");
                                }
                                break;
                            case 4:
                                System.out.println("=====DELETE PRODUCT=====");
                                System.out.println("Input product's name: ");
                                sc.nextLine();
                                productName = sc.nextLine();

                                List<Product> productListForDelete = ProductService.loadProductFromFile();
                                if (ProductService.findProductByName(productName, productListForDelete)) {
                                    ProductService.deleteProductByName(productName, productListForDelete);
                                    System.out.println("Delete product successfully!!!");
                                } else {
                                    System.err.println("Product not found");
                                }
                                break;
                            case 5:
                                System.out.println("=====VIEW PRODUCT=====");
                                System.out.println("ID,ProductName,Quantity,Price/Product,MFG,EXP,Unit,Discription,Importer,ImportDate");
                                ProductService.viewProducts();
                                break;
                            case 6:
                                System.out.println("=====FIND PRODUCT BY ID=====");
                                System.out.println("Input product's ID: ");
                                id = sc.nextInt();

                                List<Product> productListForFindID = ProductService.loadProductFromFile();
                                ProductService.findProductByID(id, productListForFindID);
                                break;
                            case 7:
                                ProductService.viewHistoryImport();
                                break;
                            case 8:
                                ProductService.viewHistoryExport();
                                break;
                            case 0:
                                run();
                                break;
                            default:
                                System.err.println("Invalid choice!!!");
                        }
                        break;
                    case 5:
                        System.out.println("=====PROVIDER SERVICE=====");
                        System.out.println("1. Add provider");
                        System.out.println("2. Update provider");
                        System.out.println("3. Delete provider");
                        System.out.println("4. View providers");
                        System.out.println("5. Find provider by name");
                        System.out.println("0. Back");
                        System.out.println("Input your choice: ");
                        int choiceProvider = sc.nextInt();
                        switch (choiceProvider) {
                            case 1:
                                System.out.println("=====ADD PROVIDER=====");
                                System.out.println("Input provider's name: ");
                                sc.nextLine();
                                String providerName = sc.nextLine();

                                System.out.println("Input provider's address: ");
                                String address = sc.nextLine();

                                System.out.println("Input provider's phone number: ");
                                String phoneNumber = sc.nextLine();

                                System.out.println("Input provider's email: ");
                                String emailProvider = sc.nextLine();

                                Provider provider = new BuilderProvider()
                                        .buildProviderName(providerName)
                                        .buildAddress(address)
                                        .buildPhoneNumber(phoneNumber)
                                        .buildEmailOfProvider(emailProvider)
                                        .build();
                                ProviderService.addProvider(provider);
                                break;
                            case 2:
                                System.out.println("=====UPDATE PROVIDER=====");
                                System.out.println("Input provider's name: ");
                                sc.nextLine();
                                providerName = sc.nextLine();

                                List<Provider> providerListForUpdate = ProviderService.loadProviderFromFile();
                                if (ProviderService.findProviderByName(providerName, providerListForUpdate)) {
                                    try {
                                        System.out.println("Update provider's name: ");
                                        String updateProviderName = sc.nextLine();

                                        System.out.println("Input provider's address: ");
                                        String updateAddress = sc.nextLine();

                                        System.out.println("Input provider's phone number: ");
                                        String updatePhoneNumber = sc.nextLine();

                                        System.out.println("Input provider's email: ");
                                        String updateEmailProvider = sc.nextLine();

                                        Provider updateProvider = new Provider(updateProviderName, updateAddress, updatePhoneNumber, updateEmailProvider);
//                                        Provider updateProvider = new BuilderProvider()
//                                                .buildProviderName(updateProviderName)
//                                                        .buildAddress(updateAddress)
//                                                                .buildPhoneNumber(updatePhoneNumber)
//                                                                        .buildEmailOfProvider(updateEmailProvider)
//                                                                                .build();
                                        ProviderService.updateProvider(providerName, updateProvider, providerListForUpdate);
                                    } catch (Exception e) {
                                        System.err.println("Nhập lại cho đúng đi má !!!");
                                    }
                                } else {
                                    System.err.println("Provider not found!!!");
                                }
                                break;
                            case 3:
                                System.out.println("=====DELETE PROVIDER=====");
                                System.out.println("Input provider's name: ");
                                sc.nextLine();
                                providerName = sc.nextLine();

                                List<Provider> providerListForDelete = ProviderService.loadProviderFromFile();

                                if (ProviderService.findProviderByName(providerName, providerListForDelete)) {
                                    ProviderService.deleteProviderByName(providerName);
                                }
                                break;
                            case 4:
                                System.out.println("=====VIEW PROVIDERS=====");
                                System.out.println("ProviderName,Address,PhoneNumber,Email");
                                ProviderService.viewProviders();
                                break;
                            case 5:
                                List<Provider> providerListForSearching = ProviderService.loadProviderFromFile();
                                System.out.println("=====FIND PROVIDER BY NAME=====");
                                System.out.println("Input provider's name: ");
                                sc.nextLine();
                                String providerNameForSearching = sc.nextLine();

                                ProviderService.findProvider(providerNameForSearching, providerListForSearching);
                                break;
                            case 0:
                                run();
                                break;
                            default:
                                System.err.println("Invalid choice!!!");
                        }
                        break;
                    case 6:
                        System.out.println("=====SET NEW ROLE=====");
                        List<User> userListForSetRole = UserService.loadUserFromFile();
                        System.out.println("Input username: ");
                        sc.nextLine();
                        String userNameForSetRole = sc.nextLine();

                        if (UserService.findUserByUserName(userNameForSetRole, userListForSetRole)) {
                            System.out.println("1. manager");
                            System.out.println("2. employee");
                            System.out.println("3. customer");
                            System.out.println("4. provider");
                            System.out.println("Input new role: ");
                            int newRole = sc.nextInt();

                            switch (newRole) {
                                case 1:
                                    UserService.setRole(userNameForSetRole, "manager");
                                    break;
                                case 2:
                                    UserService.setRole(userNameForSetRole, "employee");
                                    break;
                                case 3:
                                    UserService.setRole(userNameForSetRole, "customer");
                                    break;
                                case 4:
                                    UserService.setRole(userNameForSetRole, "provider");
                                default:
                                    System.err.println("Invalid choice!!!");
                            }
                        } else {
                            System.err.println("User not found!!!");
                        }
                        break;
                    case 7:
                        System.out.println("=====EXPORT REPORT=====");
                        System.out.println("1. Report import by date");
                        System.out.println("2. Report export by date");
                        System.out.println("3. Report import by week");
                        System.out.println("4. Report export by week");
                        System.out.println("5. Report import by month");
                        System.out.println("6. Report export by month");
                        System.out.println("7. Report import by year");
                        System.out.println("8. Report export by year");
                        System.out.println("0. Back");
                        System.out.println("Input your choice: ");
                        int choiceCase7 = sc.nextInt();
                        switch (choiceCase7) {
                            case 1:
                                System.out.println("=====REPORT IMPORT BY DATE=====");
                                System.out.println("Input year: ");
                                int yearImport1 = sc.nextInt();
                                System.out.println("Input month: ");
                                int monthImport1 = sc.nextInt();
                                System.out.println("Input day: ");
                                int dayImport1 = sc.nextInt();

                                LocalDate importDate1 = LocalDate.of(yearImport1, monthImport1, dayImport1);
                                ReportExport.importReportByDate(importDate1);
                                break;
                            case 2:
                                System.out.println("=====REPORT EXPORT BY DATE=====");
                                System.out.println("Input year: ");
                                int yearExport2 = sc.nextInt();
                                System.out.println("Input month: ");
                                int monthExport2 = sc.nextInt();
                                System.out.println("Input day: ");
                                int dayExport2 = sc.nextInt();

                                LocalDate reportDate2 = LocalDate.of(yearExport2, monthExport2, dayExport2);
                                ReportExport.exportReportByDate(reportDate2);
                                break;
                            case 3:
                                System.out.println("=====REPORT IMPORT BY WEEK=====");
                                System.out.println("Input year: ");
                                int yearExport3 = sc.nextInt();
                                System.out.println("Input month: ");
                                int monthExport3 = sc.nextInt();
                                System.out.println("Input day: ");
                                int dayExport3 = sc.nextInt();

                                LocalDate reportDate3 = LocalDate.of(yearExport3, monthExport3, dayExport3);
                                ReportExport.importReportByWeek(reportDate3);
                                break;
                            case 4:
                                System.out.println("=====REPORT EXPORT BY WEEK=====");
                                System.out.println("Input year: ");
                                int yearExport4 = sc.nextInt();
                                System.out.println("Input month: ");
                                int monthExport4 = sc.nextInt();
                                System.out.println("Input day: ");
                                int dayExport4 = sc.nextInt();

                                LocalDate reportDate4 = LocalDate.of(yearExport4, monthExport4, dayExport4);
                                ReportExport.exportReportByWeek(reportDate4);
                                break;
                            case 5:
                                System.out.println("=====REPORT IMPORT BY MONTH=====");
                                System.out.println("Input year: ");
                                int yearImport5 = sc.nextInt();
                                System.out.println("Input month: ");
                                int monthImport5 = sc.nextInt();
                                System.out.println("Input day: ");
                                int dayImport5 = sc.nextInt();

                                LocalDate importDate5 = LocalDate.of(yearImport5, monthImport5, dayImport5);
                                ReportExport.importReportByMonth(importDate5);
                                break;
                            case 6:
                                System.out.println("=====REPORT EXPORT BY MONTH=====");
                                System.out.println("Input year: ");
                                int yearExport6 = sc.nextInt();
                                System.out.println("Input month: ");
                                int monthExport6 = sc.nextInt();
                                System.out.println("Input day: ");
                                int dayExport6 = sc.nextInt();

                                LocalDate exportDate6 = LocalDate.of(yearExport6, monthExport6, dayExport6);
                                ReportExport.exportReportByMonth(exportDate6);
                                break;
                            case 7:
                                System.out.println("=====REPORT IMPORT BY YEAR=====");
                                System.out.println("Input year: ");
                                int yearImport7 = sc.nextInt();
                                System.out.println("Input month: ");
                                int monthImport7 = sc.nextInt();
                                System.out.println("Input day: ");
                                int dayImport7 = sc.nextInt();

                                LocalDate importDate7 = LocalDate.of(yearImport7, monthImport7, dayImport7);
                                ReportExport.importReportByYear(importDate7);
                                break;
                            case 8:
                                System.out.println("=====REPORT EXPORT BY YEAR=====");
                                System.out.println("Input year: ");
                                int yearExport8 = sc.nextInt();
                                System.out.println("Input month: ");
                                int monthExport8 = sc.nextInt();
                                System.out.println("Input day: ");
                                int dayExport8 = sc.nextInt();

                                LocalDate exportDate8 = LocalDate.of(yearExport8, monthExport8, dayExport8);
                                ReportExport.exportReportByYear(exportDate8);
                                break;
                            default:
                                System.err.println("Invalid choice!!!");
                        }
                        break;
                    case 0:
                        UserService.run();
                        break;
                    default:
                        System.err.println("Invalid choice!!!");
                }
            } while (true);
        } catch (Exception e) {
            System.err.println("Invalid input!!!");
        } finally {
            run();
        }
    }
}