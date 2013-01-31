package com.twu.biblioteca.ui.menus;

import com.google.common.base.Joiner;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;

import java.util.Collection;

public class BrowseMovies implements MenuItem {
    private final Library library;

    public BrowseMovies(Library library) {
        this.library = library;
    }

    @Override
    public String output() {
        Collection<Movie> movies = library.getMovieManager().getAllMovies();
        if (!movies.isEmpty()) {
            return movies.size() + " movies found\n" +
                   "Title\tYear\tDirector\tRating\n" +
                    Joiner.on('\n').join(movies);
        } else {
            return "Their are currently no movies in the library.";
        }
    }

    @Override
    public InputHandler requestInput() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
