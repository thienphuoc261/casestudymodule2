package service;

import entity.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductService extends Product implements Serializable {
    public static final String FILE_PRODUCT = "C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\dataProduct.csv";
    private static final String FILE_IMPORT = "C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\importHistory.csv";
    private static final String FILE_EXPORT = "C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\exportHistory.csv";
    private static List<Product> productList = new ArrayList<>();

    public ProductService(String s, int i, LocalDate parse) {
        super(s, i, parse);
    }

    public ProductService(int id, String productName, int quantity, int unitPriceOfProduct, String manufactureDate, String expirationDate, String unit, String discription, String importer, String importDate) {
        super(id, productName, quantity, unitPriceOfProduct, manufactureDate, expirationDate, unit, discription, importer, importDate);
    }

    public static void saveProduct() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PRODUCT, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Product product = productList.get(productList.size() - 1);
            bufferedWriter.write(product.toFileProduct() + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Product> loadProductFromFile() {
        List<Product> productList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE_PRODUCT);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<Object> arrList = new ArrayList<>(Arrays.asList(line.split(",")));
                if (arrList.size() == 10) {
                    if (isInteger(arrList.get(0)) &&
                            arrList.get(1) instanceof String &&
                            isInteger(arrList.get(2)) &&
                            isInteger(arrList.get(3)) &&
                            arrList.get(4) instanceof String &&
                            arrList.get(5) instanceof String &&
                            arrList.get(6) instanceof String &&
                            arrList.get(7) instanceof String &&
                            arrList.get(8) instanceof String &&
                            arrList.get(9) instanceof String) {
                        int id = Integer.parseInt((String) arrList.get(0));
                        String productName = (String) arrList.get(1);
                        int quantity = Integer.parseInt((String) arrList.get(2));
                        int unitPriceOfProduct = Integer.parseInt((String) arrList.get(3));
                        String manufactureDate = (String) arrList.get(4);
                        String expirationDate = (String) arrList.get(5);
                        String unit = (String) arrList.get(6);
                        String discription = (String) arrList.get(7);
                        String importer = (String) arrList.get(8);
                        String importDate = (String) arrList.get(9);

                        Product product = new Product(id, productName, quantity, unitPriceOfProduct, manufactureDate, expirationDate, unit, discription, importer, importDate);
                        productList.add(product);
                    } else {
                        System.err.println("Error: Data type does not match");
                    }
                } else {
                    System.err.println("Error: Incorrect number of elements");
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static boolean isInteger(Object object) {
        if (object instanceof Integer) {
            return true;
        }
        if (object instanceof String) {
            try {
                Integer.parseInt((String) object);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static void importProduct(Product product) {
        productList.add(product);
        saveProduct();
    }

    public static void updateProduct(String productName, Product updatedProduct, List<Product> productListForUpdate) {
        boolean productFound = false;
        for (int i = 0; i < productListForUpdate.size(); i++) {
            Product product = productListForUpdate.get(i);
            if (product.getProductName().equalsIgnoreCase(productName)) {
                productListForUpdate.set(i, updatedProduct);
                productFound = true;
                break;
            }
        }

        if (!productFound) {
            System.out.println("Provider not found: " + productName);
            return;
        }

        try {
            FileWriter fileWriter = new FileWriter(FILE_PRODUCT);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Product product : productListForUpdate) {
                bufferedWriter.write(product.toFileProduct());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteProductByName(String productName, List<Product> productListForDelete) {
        boolean productFound = false;
        Product productToRemove = null;
        for (Product product : productListForDelete) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                productToRemove = product;
                productFound = true;
                break;
            }
        }

        if (productFound) {
            productListForDelete.remove(productToRemove);
            try {
                FileWriter fileWriter = new FileWriter(FILE_PRODUCT);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Product product : productListForDelete) {
                    bufferedWriter.write(product.toFileProduct());
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Provider removed successfully.");
        } else {
            System.err.println("Provider not found.");
        }
    }

    public static void viewProducts() {
        try {
            FileReader fileReader = new FileReader(FILE_PRODUCT);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean findProductByName(String productName, List<Product> productListForFind) {
        for (Product product : productListForFind) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public static Product findProductByID(int id, List<Product> productListForFind) {
        for (Product product : productListForFind) {
            if (product.getId() == id) {
                System.out.println(product);
                return product;
            }
        }
        return null;
    }

    public static void noteHistoryImport(String productName, String discription, int quantity, int unitPriceOfProduct, String staff, String action) {
        try {
            FileWriter fw = new FileWriter(FILE_IMPORT, true);
            BufferedWriter bw = new BufferedWriter(fw);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            bw.write(dtf.format(now) + " - " + action + ": " + productName + ", " + discription + ", " + quantity + ", " + unitPriceOfProduct + ", " + (quantity * unitPriceOfProduct) + "," + staff);
            bw.newLine();

            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void noteHistoryExport(String productName, int quantity, int unitPriceOfProduct, String staff, String action) {
        try {
            FileWriter fw = new FileWriter(FILE_EXPORT, true);
            BufferedWriter bw = new BufferedWriter(fw);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            bw.write(dtf.format(now) + " - " + action + ": " + productName + ", " + quantity + ", " + unitPriceOfProduct + "," + staff);
            bw.newLine();

            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportProduct(String productName, int quantity, int id) {
        List<Product> productListForExport = loadProductFromFile();
        boolean productFound = false;

        for (Product product : productListForExport) {
            if (product.getProductName().equalsIgnoreCase(productName) && product.getId() == id) {
                if (product.getQuantity() >= quantity) {
                    product.setQuantity(product.getQuantity() - quantity);
                    productFound = true;
                    break;
                } else {
                    System.err.println("Not enough quantity to export.");
                    return;
                }
            }
        }

        if (productFound) {
            try {
                FileWriter fileWriter = new FileWriter(FILE_PRODUCT);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Product product : productListForExport) {
                    bufferedWriter.write(product.toFileProduct());
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
                fileWriter.close();
                System.out.println("Product exported successfully.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Product not found.");
        }
    }

    public static void viewHistoryImport() {
        try {
            FileReader fileReader = new FileReader(FILE_IMPORT);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Product findProductByName1(String productName, List<Product> productListForFind) {
        for (Product product : productListForFind) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public static boolean findProductByID1(int productID, List<Product> productListForFind) {
        for (Product product : productListForFind) {
            if (product.getId() == productID) {
                return true;
            }
        }
        return false;
    }

    public static void saveOrderHistoryToFile(List<Order> orderList) {
        Path filePath = Paths.get("C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\orderHistory.csv");
        List<String> lines = new ArrayList<>();

        for (Order order : orderList) {
            String line = String.format("%s,%s,%d,%s,%s,%s,%b", order.getOrderID(), order.getProductName(), order.getQuantity(), order.getOrderDate(), order.getDestination(), order.getMessage(), order.isDelivered());
            lines.add(line);
        }

        try {
            Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void updateOrderStatus(String orderID) {
        List<Order> orderList = CustomerService.loadOrderListFromFile();
        for (Order order : orderList) {
            if (order.getOrderID().equals(orderID)) {
                order.setDelivered(true);
                break;
            }
        }

        saveOrderHistoryToFile(orderList);
    }

    public static void viewHistoryExport() {
        try {
            FileReader fileReader = new FileReader(FILE_EXPORT);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}