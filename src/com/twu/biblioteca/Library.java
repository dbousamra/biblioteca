package com.twu.biblioteca;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.items.Rating;
import com.twu.biblioteca.library.BookManager;
import com.twu.biblioteca.library.MovieManager;
import com.twu.biblioteca.users.User;
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
        seedUsers();
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
        this.movieManager.addMovie(new Movie("Sholay", "1975", "Ramesh Sippy", Rating.NA));
        this.movieManager.addMovie(new Movie("The Shining", "1980", "Stanley Kubrick", Rating.EIGHT));
        this.movieManager.addMovie(new Movie("Juno", "2007", "Jason Reitman", Rating.SEVEN));
        this.movieManager.addMovie(new Movie("The Godfather", "1972", "Francis Ford Coppola", Rating.TEN));
        this.movieManager.addMovie(new Movie("Citizen Kane", "1941", "Orson Welles", Rating.TEN));

        this.movieManager.addMovie(new Movie("Pulp Fiction", "1994", "Quentin Tarantino", Rating.NINE));
        this.movieManager.addMovie(new Movie("Forrest Gump", "1994", "Robert Zemeckis", Rating.NINE));
        this.movieManager.addMovie(new Movie("Toy Story", "1995", "John Lasseter", Rating.NINE));
        this.movieManager.addMovie(new Movie("The Shawshank Redemption", "1994", "Frank Darabont", Rating.TEN));
        this.movieManager.addMovie(new Movie("Apocalypse Now", "1979", "Francis Ford Coppola", Rating.NINE));

        this.movieManager.addMovie(new Movie("Se7en", "1995", "David Fincher", Rating.EIGHT));
        this.movieManager.addMovie(new Movie("Fight Club", "1999", "David Fincher", Rating.NINE));
        this.movieManager.addMovie(new Movie("The Hobbit", "2012", "Peter Jackson", Rating.SEVEN));
        this.movieManager.addMovie(new Movie("Saving Private Ryan", "1998", "Steven Spielberg", Rating.EIGHT));
        this.movieManager.addMovie(new Movie("Titanic", "1997", "James Cameron", Rating.NINE));
    }

    private void seedUsers() {
        this.userManager.addUser(new User("111-1111", "somePassword", "Sample User", "s@s.com", "55338008"));
    }
}
