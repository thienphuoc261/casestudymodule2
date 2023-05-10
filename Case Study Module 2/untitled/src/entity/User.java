package entity;

public class User {
    private String email;
    private String userName;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public User(String email, String userName, String password, String role) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User(){
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String toFile() {
        return email + "," + userName + "," + password +"," + role;
    }
}
