package com.twu.biblioteca;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.library.BookManager;
import com.twu.biblioteca.library.MovieManager;
import com.twu.biblioteca.users.UserManager;

public final class Library {
    private final BookManager bookManager;
    private final UserManager userManager;
    private final MovieManager movieManager;

    public Library() {
        this.bookManager = new BookManager();
        this.userManager = new UserManager();
        this.movieManager = new MovieManager();

        seedBooks();
        seedMovies();
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public MovieManager getMovieManager() {
        return movieManager;
    }

    private void seedBooks() {
        this.bookManager.addBook(new Book("9780684801520", "The Great Gatsby"));
        this.bookManager.addBook(new Book("9780201310054", "Effective Java"));
        this.bookManager.addBook(new Book("9780694014361", "The Hobbit"));
    }

    private void seedMovies() {
        this.movieManager.addMovie(new Movie("Sholay", "1975", "Ramesh Sippy", false));
        this.movieManager.addMovie(new Movie("The Shining", "1980", "Stanley Kubrick", true));
        this.movieManager.addMovie(new Movie("Juno", "2007", "Jason Reitman", true));
        this.movieManager.addMovie(new Movie("The Godfather", "1972", "Francis Ford Coppola", true));
        this.movieManager.addMovie(new Movie("Citizen Kane", "1941", "Orson Welles", true));

        this.movieManager.addMovie(new Movie("Pulp Fiction", "1994", "Quentin Tarantino", true));
        this.movieManager.addMovie(new Movie("Forrest Gump", "1994", "Robert Zemeckis", true));
        this.movieManager.addMovie(new Movie("Toy Story", "1995", "John Lasseter", true));
        this.movieManager.addMovie(new Movie("The Shawshank Redemption", "1994", "Frank Darabont", true));
        this.movieManager.addMovie(new Movie("Apocalypse Now", "1979", "Francis Ford Coppola", true));

        this.movieManager.addMovie(new Movie("Se7en", "1995", "David Fincher", true));
        this.movieManager.addMovie(new Movie("Fight Club", "1999", "David Fincher", true));
        this.movieManager.addMovie(new Movie("The Hobbit - An Unexpected Journey", "2012", "Peter Jackson", true));
        this.movieManager.addMovie(new Movie("Saving Private Ryan", "1998", "Steven Spielberg", true));
        this.movieManager.addMovie(new Movie("Titanic", "1997", "James Cameron", true));
    }
}
