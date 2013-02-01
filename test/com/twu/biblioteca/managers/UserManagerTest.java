package com.twu.biblioteca.managers;

import com.twu.biblioteca.users.User;
import com.twu.biblioteca.users.UserManager;
import org.junit.Test;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class UserManagerTest {
    @Test
    public void testUserManagerCreation() throws Exception {
        UserManager userManager = new UserManager();
        assertNotNull(userManager);
    }

    @Test
    public void testAddRegisteredUsers() throws Exception {
        UserManager userManager = new UserManager();
        User user = new User("111-1111", "somePassword");
        userManager.addUser(user);
        assertThat(userManager.getAllUsers(), hasItem(user));
    }


}
