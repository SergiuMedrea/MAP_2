package com.mergiu.QuickByteBE;

import com.mergiu.QuickByteBE.domain.user.AdminUserDecorator;
import com.mergiu.QuickByteBE.domain.user.SimpleUser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminUserDecoratorTest {

    @Test
    void testGetId() {
        SimpleUser simpleUser = mock(SimpleUser.class);
        when(simpleUser.getId()).thenReturn(1L);

        AdminUserDecorator adminUserDecorator = new AdminUserDecorator(simpleUser);

        assertEquals(1L, adminUserDecorator.getId());
    }

    @Test
    void testGetFirstName() {
        SimpleUser simpleUser = mock(SimpleUser.class);
        when(simpleUser.getFirstName()).thenReturn("John");

        AdminUserDecorator adminUserDecorator = new AdminUserDecorator(simpleUser);

        assertEquals("John", adminUserDecorator.getFirstName());
    }

    @Test
    void testGetLastName() {
        SimpleUser simpleUser = mock(SimpleUser.class);
        when(simpleUser.getLastName()).thenReturn("Doe");

        AdminUserDecorator adminUserDecorator = new AdminUserDecorator(simpleUser);

        assertEquals("Doe", adminUserDecorator.getLastName());
    }

    @Test
    void testGetPhoneNumber() {
        SimpleUser simpleUser = mock(SimpleUser.class);
        when(simpleUser.getPhoneNumber()).thenReturn("123-456-7890");

        AdminUserDecorator adminUserDecorator = new AdminUserDecorator(simpleUser);

        assertEquals("123-456-7890", adminUserDecorator.getPhoneNumber());
    }

    @Test
    void testGetRole() {
        SimpleUser simpleUser = mock(SimpleUser.class);

        AdminUserDecorator adminUserDecorator = new AdminUserDecorator(simpleUser);

        assertEquals("Admin", adminUserDecorator.getRole());
    }
}
