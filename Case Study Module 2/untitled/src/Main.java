import service.ReportExport;
import service.UserService;

import java.time.LocalDate;

import static service.UserService.loadUserFromFile;

public class Main {
    public static void main(String[] args) {
        loadUserFromFile();
        UserService.run();
    }
}
