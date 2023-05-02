package service;

import entity.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductService extends Product implements Serializable {
    private static final String FILE_PRODUCT = "C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\dataProduct.txt";
    public static List<Product> productList = new ArrayList<>();

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
                if (arrList.size() == 8) {
                    if (isInteger(arrList.get(0)) &&
                            arrList.get(1) instanceof String &&
                            isInteger(arrList.get(2)) &&
                            isInteger(arrList.get(3)) &&
                            arrList.get(4) instanceof String &&
                            arrList.get(5) instanceof String &&
                            arrList.get(6) instanceof String &&
                            arrList.get(7) instanceof String) {
                        int id = Integer.parseInt((String) arrList.get(0));
                        String productName = (String) arrList.get(1);
                        int quantity = Integer.parseInt((String) arrList.get(2));
                        int unitPriceOfProduct = Integer.parseInt((String) arrList.get(3));
                        String manufactureDate = (String) arrList.get(4);
                        String expirationDate = (String) arrList.get(5);
                        String unit = (String) arrList.get(6);
                        String discription = (String) arrList.get(7);

                        Product product = new Product(id, productName, quantity, unitPriceOfProduct, manufactureDate, expirationDate, unit, discription);
                        productList.add(product);
                    } else {
                        System.err.println("Lỗi: Kiểu dữ liệu không phù hợp.");
                    }
                } else {
                    System.err.println("Lỗi: Số lượng phần tử không đúng.");
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    private static boolean isInteger(Object object) {
        if (object instanceof Integer) {
            return true;
        }
        if (object instanceof String) {
            try {
                Integer.parseInt((String) object);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    public static void addProduct(Product product) {
        productList.add(product);
        saveProduct();
    }

    public static void updateProduct(String productName, Product updatedProduct, List<Product> productList1) {
        boolean productFound = false;
        for (int i = 0; i < productList1.size(); i++) {
            Product product = productList1.get(i);
            if (product.getProductName().equalsIgnoreCase(productName)) {
                productList1.set(i, updatedProduct);
                productFound = true;
                break;
            }
        }

        if (!productFound) {
            System.out.println("Không tìm thấy sản phẩm có tên: " + productName);
            return;
        }

        try {
            FileWriter fileWriter = new FileWriter(FILE_PRODUCT);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Product product : productList1) {
                bufferedWriter.write(product.toFileProduct());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProductByName(String productName, List<Product> productList1) {
        boolean productFound = false;
        Product productToRemove = null;
        for (Product product : productList1) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                productToRemove = product;
                productFound = true;
                break;
            }
        }

        if (productFound) {
            productList1.remove(productToRemove);
            try {
                FileWriter fileWriter = new FileWriter(FILE_PRODUCT);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Product product : productList1) {
                    bufferedWriter.write(product.toFileProduct());
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Product removed successfully.");
        } else {
            System.err.println("Product not found.");
        }
    }

    public static boolean findProductByName(String productName, List<Product> productList1) {
        for (Product product : productList1) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
}