package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testCreationOfUser() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    public void testCheckMembershipDetails() throws Exception {
        User user = new User();
        assertEquals(user.checkMembershipDetails(), "Please talk to a Librarian. Thank you.");
    }
}
