package com.twu.biblioteca.users;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserManager {

    public UserManager() { }

    private Set<User> registeredUsers = new HashSet<User>();

    public Optional<User> getCurrentlyLoggedInUser() {
        return currentlyLoggedInUser;
    }

    private Optional<User> currentlyLoggedInUser = Optional.absent();

    public Set<User> getAllUsers() {
        return Collections.unmodifiableSet(registeredUsers);
    }

    public void addUser(User user) {
        this.registeredUsers.add(user);
    }

    public Optional<User> authenticateUser(final String username, final String password) {
        Optional<User> possibleUser =  Iterables.tryFind(registeredUsers, new Predicate<User>() {
            @Override
            public boolean apply(User user) {
                return user.getUsername().equals(username) &&
                       user.getPassword().equals(password);
            }
        });
        this.currentlyLoggedInUser = possibleUser;
        return possibleUser;
    }
}
