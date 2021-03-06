package com.twu.biblioteca.items;

import com.twu.biblioteca.users.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User getMockUser() {
        return new User("111-1111", "somePassword", "Sample User", "s@s.com", "55338008");
    }

    @Test
    public void testCreationOfUserWithValidData() {
        User user = getMockUser();
        assertEquals("111-1111", user.getUsername());
        assertEquals("somePassword", user.getPassword());
    }

    @Test
    public void testCheckMembershipDetails() throws Exception {
        User user = getMockUser();
        assertEquals(user.checkMembershipDetails(), "Please talk to a Librarian. Thank you.");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testUserConstructionWithInvalidData() throws Exception {
        String malformedUsername = "111-111";
        String validPassword = "somePassword";
        User user = new User(malformedUsername, validPassword, "Sample User", "s@s.com", "55338008");
    }

    @Test
    public void testUserToStringDisplaysCredentials() throws Exception {
        User user = getMockUser();
        assertEquals(user.toString(), "Sample User s@s.com 55338008");
    }
}
