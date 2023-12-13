package com.mergiu.QuickByteBE.domain.user;

public class AdminUserDecorator extends SimpleUser {
    private final SimpleUser decoratedUser;

    public AdminUserDecorator(User decoratedUser) {
        this.decoratedUser = (SimpleUser) decoratedUser;
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

    public String getRole() {
        return "Admin";
    }
}