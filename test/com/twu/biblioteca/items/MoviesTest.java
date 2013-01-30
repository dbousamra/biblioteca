package com.twu.biblioteca.items;

import com.twu.biblioteca.items.Movie;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MoviesTest {

    @Test
    public void testCanConstructBookAndIsNotNull() throws Exception {
        Movie movie = new Movie("Sholay", "1975", "Ramesh Sippy", false);
        assertNotNull(movie);
    }

    @Test
    public void testCanConstructBookAndFieldsMatch() throws Exception {
        Movie movie = new Movie("Sholay", "1975", "Ramesh Sippy", false);
        assertEquals("Sholay", movie.getTitle());
        assertEquals("1975", movie.getYear());
        assertEquals("Ramesh Sippy", movie.getDirector());
        assertEquals(false, movie.isRated());
    }
}
