package com.twu.biblioteca.users;

public class User {

    private final String username;
    private final String password;

    public User(String username, String password) {
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
