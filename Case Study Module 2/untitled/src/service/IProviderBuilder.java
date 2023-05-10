package service;

import entity.Provider;

public interface IProviderBuilder {
    public IProviderBuilder buildProviderName (String providerName);
    public IProviderBuilder buildAddress (String address);
    public IProviderBuilder buildPhoneNumber (String phoneNumber);
    public IProviderBuilder buildEmailOfProvider (String emailOfProvider);
    public Provider build();
}
