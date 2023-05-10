package entity;

public class Shipment {
    private String productName;
    private int quantity;
    private int weight;
    private String destination;
    private String deliveryDate;
    private boolean shippingStatus;
    private String deliveryService;

    public Shipment(String productName, int quantity, int weight, String destination, String deliveryDate, boolean shippingStatus) {
        this.productName = productName;
        this.quantity = quantity;
        this.weight = weight;
        this.destination = destination;
        this.deliveryDate = deliveryDate;
        this.shippingStatus = shippingStatus;
    }

    public Shipment() {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(boolean shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(String deliveryService){
        this.deliveryService = deliveryService;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", weight=" + weight +
                ", destination='" + destination + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", shippingStatus=" + shippingStatus +
                ", deliveryService='" + deliveryService + '\'' +
                '}';
    }

    public String toFile() {
        return productName + "," + quantity + "," + weight + "," + destination + "," + deliveryDate + "," + shippingStatus;
    }
}
