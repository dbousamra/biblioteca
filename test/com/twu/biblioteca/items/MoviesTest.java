package com.twu.biblioteca.items;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MoviesTest {

    @Test
    public void testCanConstructBookAndIsNotNull() throws Exception {
        Movie movie = new Movie("Sholay", "1975", "Ramesh Sippy", Rating.TEN);
        assertNotNull(movie);
    }

    @Test
    public void testCanConstructBookAndFieldsMatch() throws Exception {
        Movie movie = new Movie("Sholay", "1975", "Ramesh Sippy", Rating.TEN);
        assertEquals("Sholay", movie.getTitle());
        assertEquals("1975", movie.getYear());
        assertEquals("Ramesh Sippy", movie.getDirector());
        assertEquals(Rating.TEN, movie.getRating());
    }

    @Test
    public void testMoviesToStringIsPaddedCorrectly() throws Exception {
        Movie movie = new Movie("Sholay", "1975", "Ramesh Sippy", Rating.TEN);
        Movie movie2 = new Movie("The Shawshank Redemption", "1994", "Francis Ford Coppola", Rating.TEN);
        assertEquals("1975 Sholay                    Ramesh Sippy              10/10", movie.toString());
        assertEquals("1994 The Shawshank Redemption  Francis Ford Coppola      10/10", movie2.toString());
    }
}
