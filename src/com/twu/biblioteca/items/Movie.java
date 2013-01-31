package com.twu.biblioteca.items;

public class Movie {
    private final String title;
    private final String year;
    private final String director;
    private final Rating rating;

    public Movie(String title, String year,  String director,  Rating rated) {
        this.rating = rated;
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
        return this.rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (director != null ? !director.equals(movie.director) : movie.director != null) return false;
        if (rating != movie.rating) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
