package entity;

public class Product {
    private int id;
    private String productName;
    private int quantity;
    private int unitPriceOfProduct;
    private String manufactureDate;
    private String expirationDate;
    private String unit;
    private String discription;


    public Product(){
    }

    public Product(int id ,String productName, int quantity, int unitPriceOfProduct, String manufactureDate, String expirationDate, String unit, String discription) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPriceOfProduct = unitPriceOfProduct;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.unit = unit;
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPriceOfProduct() {
        return unitPriceOfProduct;
    }

    public void setUnitPriceOfProduct(int unitPriceOfProduct) {
        this.unitPriceOfProduct = unitPriceOfProduct;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPriceOfProduct=" + unitPriceOfProduct +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", unit='" + unit + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }

    public String toFileProduct(){
        return id + "," + productName + "," + quantity + "," + unitPriceOfProduct + "," + manufactureDate + "," + expirationDate + "," + unit + "," + discription;
    }
}