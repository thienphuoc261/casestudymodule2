package service.impl;

import service.Staff;

import java.util.Scanner;

public class Employee implements Staff {
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
            System.out.println("=====WELCOME EMPLOYEE=====");
            System.out.println("Please select an option:");
            System.out.println("1. Check-in Product");
            System.out.println("2. Check-out Product");
            System.out.println("3. Confirm order from Customer");
            System.out.println("4. Create shipment");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Invalid choice!!!");
            }
        }while (true);
    }
}
