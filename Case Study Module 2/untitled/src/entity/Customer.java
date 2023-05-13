package entity;

import service.Order;
import java.util.*;

public class Customer {
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String emailOfCustomer;
    public static List<Order> ordersHistory = new ArrayList<>();

    public Customer() {
    }

    public Customer(String customerName, String customerAddress, String customerPhoneNumber, String emailOfCustomer) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.emailOfCustomer = emailOfCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getEmailOfCustomer() {
        return emailOfCustomer;
    }

    public void setEmailOfCustomer(String emailOfCustomer) {
        this.emailOfCustomer = emailOfCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", emailOfCustomer='" + emailOfCustomer + '\'' +
                '}';
    }

    public String toFile() {
        return customerName + "," + customerAddress + "," + customerPhoneNumber + "," + emailOfCustomer;
    }
}