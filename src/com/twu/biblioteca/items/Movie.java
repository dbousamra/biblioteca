package com.twu.biblioteca.items;

public class Movie {
    private final String title;
    private final String year;
    private final String director;
    private final boolean rated;

    public Movie(String title, String year,  String director,  boolean rated) {
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

    public boolean isRated() {
        return this.rated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (rated != movie.rated) return false;
        if (!director.equals(movie.director)) return false;
        if (!title.equals(movie.title)) return false;
        if (!year.equals(movie.year)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + director.hashCode();
        result = 31 * result + (rated ? 1 : 0);
        return result;
    }
}
