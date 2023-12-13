package com.mergiu.QuickByteBE.domain.user;

public class UserRoleDecorator extends SimpleUser {
    private final SimpleUser decoratedUser;
    private final String role;

    public UserRoleDecorator(User decoratedUser, String role) {
        this.decoratedUser = (SimpleUser) decoratedUser;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public Long getId() {
        return decoratedUser.getId();
    }

    @Override
    public String getFirstName() {
        return decoratedUser.getFirstName();
    }

    @Override
    public String getLastName() {
        return decoratedUser.getLastName();
    }

    @Override
    public String getPhoneNumber() {
        return decoratedUser.getPhoneNumber();
    }
}

