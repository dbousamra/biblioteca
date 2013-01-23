package com.twu.biblioteca;

import com.twu.biblioteca.Reservable;

public class Book implements Reservable {
    @Override
    public boolean isReservable() {
        return false;
    }
}
