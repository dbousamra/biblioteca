package com.twu.biblioteca.managers;

import com.twu.biblioteca.items.Movie;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MovieManager {

    private Set<Movie> movies = new HashSet<Movie>();

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public int getMovieCount() {
        return this.movies.size();
    }

    public Set<Movie> getAllMovies() {
        return Collections.unmodifiableSet(this.movies);
    }

}
