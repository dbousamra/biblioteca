package com.twu.biblioteca.items;

public class Movie {
    private final String title;
    private final String year;
    private final String director;
    private final Rating rated;

    public Movie(String title, String year,  String director,  Rating rated) {
        this.rated = rated;
        this.director = director;
        this.year = year;
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getYear() {
        return this.year;
    }

    public String getDirector() {
        return this.director;
    }

    public Rating getRating() {
        return this.rated;
    }
}
