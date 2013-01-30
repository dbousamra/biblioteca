package com.twu.biblioteca.managers;

import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.library.BookManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MovieReservationManagerTest {

    private Movie getMockMovie() {
        return new Movie("The Shining", "1980", "Stanley Kubrick", true);
    }

    @Test
    public void testMovieReservationManagerCreation() throws Exception {
        MovieManager mrm = new MovieManager();
        assertNotNull(mrm);
    }

    @Test
    public void testAddMovieToRepository() throws Exception {
        Movie movie = getMockMovie();
        MovieManager mrm = new MovieManager();
        mrm.addMovie(movie);
        assertEquals(1, mrm.getItemCount());
    }

    @Test
    public void testGetListOfMovies() throws Exception {
       Movie movie = getMockMovie();
       MovieManager mrm = new MovieManager();
       mrm.addMovie(movie);
       assertEquals(1, mrm.getListOfAllMovies().size());
    }
}
