import entity.Customer;
import service.UserService;
import static service.UserService.loadUserFromFile;

public class Main {
    public static void main(String[] args) {
        loadUserFromFile();
        UserService userService = new UserService();
        userService.run();

//        System.out.println(Customer.loadOrderHistoryFromFile());
    }
}
