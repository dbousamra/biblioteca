package com.twu.biblioteca;

import org.junit.Test;
import static junit.framework.Assert.*;

public class BookTest {

    @Test
    public void testBookCreation() throws Exception {
        Book book = new Book("9780140177398", "Of Mice and Men");
        assertEquals(book.getISBN(), "9780140177398");
        assertEquals(book.getTitle(), "Of Mice and Men");
    }

    @Test
    public void testSuccessMessage() throws Exception {
        Book book = new Book("9780201310054", "Effective Java");
    }
}
