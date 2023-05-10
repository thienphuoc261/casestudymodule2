package entity;

public class Provider {
    private String providerName;
    private String address;
    private String phoneNumber;
    private String emailOfProvider;

    public Provider() {
    }

    public Provider(String providerName, String address, String phoneNumber, String emailOfProvider) {
        this.providerName = providerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailOfProvider = emailOfProvider;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailOfProvider() {
        return emailOfProvider;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "Provider Name='" + providerName + '\'' +
                ", Address='" + address + '\'' +
                ", Phone Number='" + phoneNumber + '\'' +
                ", Email Of Provider='" + emailOfProvider + '\'' +
                '}';
    }

    public String toFileProvider(){
        return providerName + "," + address + "," + phoneNumber + "," + emailOfProvider;
    }
}
