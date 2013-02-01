package com.twu.biblioteca.managers;

import com.google.common.base.Optional;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.users.UserManager;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
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

    @Test
    public void testAuthenticateValidUser() throws Exception {
        UserManager userManager = new UserManager();
        User user = new User("111-1111", "somePassword");
        userManager.addUser(user);
        Optional<User> possibleUser = userManager.authenticateUser("111-1111", "somePassword");
        assertTrue(possibleUser.isPresent());
        assertThat(possibleUser.get().getUsername(), is(equalTo("111-1111")));
    }

    @Test
    public void testAuthenticateInvalidUser() throws Exception {
        UserManager userManager = new UserManager();
        User user = new User("111-1111", "somePassword");
        userManager.addUser(user);
        Optional<User> possibleUser = userManager.authenticateUser("111-1111", "invalidPassword");
        assertFalse(possibleUser.isPresent());
    }
}
