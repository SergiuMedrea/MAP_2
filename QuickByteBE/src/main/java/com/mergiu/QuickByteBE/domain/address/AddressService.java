package com.mergiu.QuickByteBE.domain.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }


    public void addNewAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        boolean exists = addressRepository.existsById(addressId);

        if (!exists)
            throw new IllegalStateException("Address with id " + addressId + " does not exist");

        addressRepository.deleteById(addressId);
    }

    public void updateAddress(Long addressId, String street, String postalCode, String city, String country) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new IllegalStateException("address with id " + addressId + " does not exist"));

        if (street != null &&
                !street.isEmpty() &&
                !street.equals(address.getStreet())) {
            address.setStreet(street);
        }

        if (postalCode != null &&
                !postalCode.isEmpty() &&
                !postalCode.equals(address.getPostalCode())) {
            address.setPostalCode(postalCode);
        }

        if (city != null &&
                !city.isEmpty() &&
                !city.equals(address.getCity())) {
            address.setCity(city);
        }

        if (country != null &&
                !country.isEmpty() &&
                !country.equals(address.getCountry())) {
            address.setCountry(country);
        }

        addressRepository.save(address);
    }
}
