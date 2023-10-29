package repo.inMemory;

import entities.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressRepo {
    private final List<Address> addresses = new ArrayList<>();
    private long nextAddressID = 1;

    /**
     * Create a new address and add it to the repository
     */
    public Address createAddress(String street, String postalCode, String city, String country) {
        Address newAddress = new Address(nextAddressID, street, postalCode, city, country);
        addresses.add(newAddress);
        nextAddressID++;
        return newAddress;
    }

    /**
     * Retrieve an address by ID | NULL if not found
     */
    public Address getAddressByID(Long addressID) {
        return addresses.stream()
                .filter(address -> address.addressID().equals(addressID))
                .findFirst()
                .orElse(null);
    }

    public List<Address> getAllAddresses() {
        return new ArrayList<>(addresses);
    }

    /**
     * Update an existing address and return the updated address
     */
    public Address updateAddress(Address updatedAddress) {
        for (int i = 0; i < addresses.size(); i++) {
            Address address = addresses.get(i);
            if (address.addressID().equals(updatedAddress.addressID())) {
                addresses.set(i, updatedAddress);
                return updatedAddress;
            }
        }

        return null; // Address not found
    }

    /**
     * Delete an address by ID
     */
    public boolean deleteAddress(Long addressID) {
        return addresses.removeIf(address -> address.addressID().equals(addressID));
    }
}
