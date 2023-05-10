package service;

import java.time.LocalDate;

public class OrderRequest {
    private String productName;
    private int quantity;
    private LocalDate orderDate;

    public OrderRequest(String productName, int quantity, LocalDate orderDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}