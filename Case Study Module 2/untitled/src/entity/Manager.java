package entity;
import service.ProductService;
import service.ProviderService;
import service.UserService;
import service.impl.BuiderProduct;
import service.impl.BuilderProvider;
import java.util.List;
import java.util.Scanner;

public class Manager {

    public static void run(){
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
                        ProductService.confirmOrderFromCustomer();
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
                        System.out.println("7. View history of im-export");
                        System.out.println("Input your choice: ");
                        int choiceProduct = sc.nextInt();
                        switch (choiceProduct) {
                            case 1:
                                System.out.println("=====IMPORT PRODUCT=====");
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
                                String discription = sc.nextLine();

                                System.out.println("Input importer: ");
                                String importer = sc.nextLine();

                                System.out.println("Input import date: ");
                                String importDate = sc.nextLine();
//                                Product newProduct = new Product(id, productName, quantity, unitPriceOfProduct, manufactureDate, expirationDate, unit, description, importer, importDate);
                                Product newProduct = new BuiderProduct()
                                        .buildID(id)
                                                .buildProductName(productName)
                                                        .buildQuantity(quantity)
                                                                .buildUnitPriceOfProduct(unitPriceOfProduct)
                                                                        .buildManufactureDate(manufactureDate)
                                                                                .buildExpirationDate(expirationDate)
                                                                                        .buildUnit(unit)
                                                                                                .buildDiscription(discription)
                                                                                                        .buildImporter(importer)
                                                                                                                .buildImportDate(importDate)
                                                                                                                        .build();
                                ProductService.importProduct(newProduct);
                                ProductService.noteHistoryImport(productName,discription,quantity,unitPriceOfProduct,importer,"IMPORT");
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

                                ProductService.exportProduct(productNameExport,quantityExport,idExport);
                                ProductService.noteHistoryExport(productNameExport,descriptionExport,quantityExport,unitPriceOfProductExport,exporter,"EXPORT");
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

//                                Provider provider = new Provider(providerName, address, phoneNumber, emailProvider);
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
                                        ProviderService.updateProvider(providerName, updateProvider,providerListForUpdate);
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
                            System.out.println("Input new role: ");
                            String newRole = sc.nextLine();
                            switch (newRole){
                                case "manager":
                                    UserService.setRole(userNameForSetRole, "manager");
                                    break;
                                case "employee":
                                    UserService.setRole(userNameForSetRole, "employee");
                                    break;
                                case "customer":
                                    UserService.setRole(userNameForSetRole, "customer");
                                    break;
                                case "provider":
                                    UserService.setRole(userNameForSetRole, "provider");
                                default:
                                    System.err.println("Invalid role!!!");
                            }
                        } else {
                            System.err.println("User not found!!!");
                        }
                        break;
                    case 7:
                        System.out.println("=====EXPORT REPORT=====");
                        System.out.println("1. Export report in one day: ");
                        System.out.println("2. Export report in one week: ");
                        System.out.println("3. Export report in one month: ");
                        System.out.println("4. Export report in one quarter: ");
                        System.out.println("5. Export report in one year: ");
                        System.out.println("Input your choice: ");
                        int choiceReport = sc.nextInt();
                        switch (choiceReport) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
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
        } catch (Exception e){
            System.err.println("Invalid choice!!!");
        } finally {
            run();
        }
    }
}