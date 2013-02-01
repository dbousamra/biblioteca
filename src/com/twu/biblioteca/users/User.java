package com.twu.biblioteca.users;

import static com.google.common.base.Preconditions.checkArgument;

public class User {

    private final String username;
    private final String password;
    private final String name;
    private final String emailAddress;
    private final String phoneNumber;

    /*
    * Constructor uses regex pattern and Guava static Preconditions to handle argument checking.
    * Throws an IllegalArgumentException.
    */
    public User(String username, String password, String name, String emailAddress, String phoneNumber) {
        checkArgument(username.matches("\\d{3}-\\d{4}"),
                "Username must conform to digit pattern XXX-XXXX, but was %s", username);
        this.username = username;
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
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

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}