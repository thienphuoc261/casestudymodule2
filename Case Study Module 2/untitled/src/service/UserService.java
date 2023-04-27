package service;

import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService extends User implements Serializable {
    private static final String FILE_PATH = "src\\data\\data.txt";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9]{8,}$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static List<User> userList = new ArrayList<>();

    public UserService() {
    }

    public static boolean register(String email, String userName, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                System.err.println("Email is already exist!!!");
                return false;
            }
            if (user.getUserName().equals(userName)) {
                System.err.println("User name is already exist!!!");
                return false;
            }
            if (!isValidEmail(email)) {
                System.err.println("Invalid email format!!!");
                return false;
            }
            if (!isValidUserName(userName)) {
                System.err.println("Invalid username format!!!");
                return false;
            }
            if (!isValidPassword(password)) {
                System.err.println("Invalid password format!!!");
                return false;
            }
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidUserName(String userName) {
        Pattern pattern = Pattern.compile(USERNAME_REGEX);
        Matcher matcher = pattern.matcher(userName);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean logIn(String userName, String password) {
        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static User findUserByUserName(String userName) {
        for (User user : userList) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public static void saveUser() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User user : userList) {
                bufferedWriter.write(user.toFile() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> loadUserFromFile() {
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] arr = new String[3];
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                userList.add(new User(arr[0], arr[1], arr[2]));
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Input User Name: ");
                    String userName = scanner.next();
                    System.out.println("Input password: ");
                    String password = scanner.next();
                    System.out.println("Input email: ");
                    String email = scanner.next();
                    if (register(email,userName,password)) {
                        User user = new User(email, userName, password);
                        userList.add(user);
                        saveUser();
                        break;
                    }
                    else{
                        System.err.println("Enter again");
                    }
                    break;
                case 2:
                    loadUserFromFile();
                    System.out.println("Input User Name: ");
                    String userName1 = scanner.next();
                    System.out.println("Input password: ");
                    String password1 = scanner.next();
                    if(logIn(userName1, password1)){
                        System.out.println("Log in successfully !!!");
                    } else {
                        System.err.println("Fail to log in");
                    }
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.err.println("Invalid choice. Please select again.");
            }
        } while (true);
    }
}
