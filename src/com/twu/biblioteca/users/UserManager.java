package com.twu.biblioteca.users;

import com.twu.biblioteca.items.Movie;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserManager {

    public UserManager() { }

    private Set<User> registeredUsers = new HashSet<User>();



    public Set<User> getAllUsers() {
        return Collections.unmodifiableSet(registeredUsers);
    }

    public void addUser(User user) {
        this.registeredUsers.add(user);
    }
}
