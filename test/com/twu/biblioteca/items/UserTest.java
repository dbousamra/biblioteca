package com.twu.biblioteca.items;

import com.twu.biblioteca.users.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User getMockUser() {
        return new User("111-1111", "somePassword");
    }

    @Test
    public void testCreationOfUser() {
        User user = getMockUser();
        assertEquals("111-1111", user.getUsername());
        assertEquals("somePassword", user.getPassword());
    }

    @Test
    public void testCheckMembershipDetails() throws Exception {
        User user = getMockUser();
        assertEquals(user.checkMembershipDetails(), "Please talk to a Librarian. Thank you.");
    }
}
