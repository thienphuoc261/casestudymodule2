import service.UserService;
import static service.UserService.loadUserFromFile;

public class Main {
    public static void main(String[] args) {
        loadUserFromFile();
        UserService.run();
    }
}
