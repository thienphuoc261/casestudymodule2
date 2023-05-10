package service.impl;

import entity.Provider;
import service.IProviderBuilder;

public class BuilderProvider implements IProviderBuilder {
    private String providerName;
    private String address;
    private String phoneNumber;
    private String emailOfProvider;
    @Override
    public IProviderBuilder buildProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    @Override
    public IProviderBuilder buildAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public IProviderBuilder buildPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public IProviderBuilder buildEmailOfProvider(String emailOfProvider) {
        this.emailOfProvider = emailOfProvider;
        return this;
    }

    @Override
    public Provider build() {
        return new Provider(providerName, address, phoneNumber, emailOfProvider);
    }
}
