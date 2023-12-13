package com.mergiu.QuickByteBE.domain.user;

public interface UserObserver {
    void onUserCreated(SimpleUser simpleUser);
    void onUserUpdated(SimpleUser simpleUser);
    void onUserDeleted(Long userId);
}
