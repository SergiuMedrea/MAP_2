package domain;

public class User implements Identifiable {
    private int userID;
    private int addressID;
    private String firstName;
    private String lastName;
    private String phoneNumber;


    public User(int userID, int addressID, String firstName, String lastName, String phoneNumber) {
        this.userID = userID;
        this.addressID = addressID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int getId() {
        return userID;
    }

    @Override
    public void setId(int id) {
        userID = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
