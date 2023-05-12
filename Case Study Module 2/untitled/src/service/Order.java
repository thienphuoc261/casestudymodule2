package service;

import java.time.LocalDate;
import java.util.UUID;

public class Order {
    private String orderID;
    private String productName;
    private int quantity;
    private LocalDate orderDate;
    private String destination;
    private String message;
    private boolean isDelivered;


    public Order(String productName, int quantity, LocalDate orderDate, String destination, String message, boolean isDelivered) {
        this.orderID = UUID.randomUUID().toString();
        this.productName = productName;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.destination = destination;
        this.message = message;
        this.isDelivered = isDelivered;
    }

    public Order(String orderID, String productName, int quantity, LocalDate orderDate, String destination, String message, boolean isDelivered) {
        this.orderID = orderID;
        this.productName = productName;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.destination = destination;
        this.message = message;
        this.isDelivered = isDelivered;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", destination='" + destination + '\'' +
                ", message='" + message + '\'' +
                ", isDelivered=" + isDelivered +
                '}';
    }

    public String toFile(){
        return orderID + "," + productName + "," + quantity + "," + orderDate + "," + destination + "," + message + "," + isDelivered;
    }
}
