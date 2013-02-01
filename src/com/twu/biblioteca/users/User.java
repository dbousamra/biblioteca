package com.twu.biblioteca.users;

import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;

public class User {

    private final String username;
    private final String password;


    /*
    * Constructor uses regex pattern and Guava static Preconditions to handle argument checking.
    * Throws an IllegalArgumentException.
    */
    public User(String username, String password) {
        checkArgument(username.matches("\\d{3}-\\d{4}"),
                "Username must conform to digit pattern XXX-XXXX, but was %s", username);
        this.username = username;
        this.password = password;
    }

    public String checkMembershipDetails() {
        return "Please talk to a Librarian. Thank you.";
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {

        return username;
    }
}
