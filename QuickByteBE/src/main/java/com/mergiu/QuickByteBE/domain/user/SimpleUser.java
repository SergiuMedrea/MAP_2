package com.mergiu.QuickByteBE.domain.user;

import com.mergiu.QuickByteBE.domain.address.Address;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SimpleUser implements User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id", referencedColumnName = "id")
    private Address address;

    public SimpleUser() {
    }

    public SimpleUser(String firstName, String lastName, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long userId) {
        this.id = userId;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }

    @Transient
    private final List<UserObserver> observers = new ArrayList<>();

    public void addObserver(UserObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(UserObserver observer) {
        observers.remove(observer);
    }

    void notifyUserCreated() {
        for (UserObserver observer : observers) {
            observer.onUserCreated(this);
        }
    }

    private void notifyUserUpdated() {
        for (UserObserver observer : observers) {
            observer.onUserUpdated(this);
        }
    }

    private void notifyUserDeleted() {
        for (UserObserver observer : observers) {
            observer.onUserDeleted(this.id);
        }
    }

    @PrePersist
    public void prePersist() {
        notifyUserCreated();
    }

    @PreUpdate
    public void preUpdate() {
        notifyUserUpdated();
    }

    @PreRemove
    public void preRemove() {
        notifyUserDeleted();
    }

    @Override
    public String getUsername() {
        return firstName + lastName;
    }
}