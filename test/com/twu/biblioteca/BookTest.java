package com.twu.biblioteca;

import com.twu.biblioteca.items.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testBookCreation() throws Exception {
        Book book = new Book("9780140177398", "Of Mice and Men");
        assertEquals(book.getISBN(), "9780140177398");
        assertEquals(book.getTitle(), "Of Mice and Men");
    }
}
