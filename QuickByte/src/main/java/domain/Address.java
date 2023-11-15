package domain;

public class Address implements Identifiable {
    private int addressID;
    private String street;
    private String postalCode;
    private String city;
    private String country;

    public Address(int addressID, String street, String postalCode, String city, String country) {
        this.addressID = addressID;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    @Override
    public void setId(int id) {
        setAddressID(id);
    }

    @Override
    public int getId() {
        return getAddressID();
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
