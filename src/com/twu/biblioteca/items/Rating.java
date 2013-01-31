package com.twu.biblioteca.items;

public enum Rating {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    NA(0);

    private int value;

    private Rating(int value) {
        this.value = value;
    }
}

