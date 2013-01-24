package com.twu.biblioteca;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.BookNotFoundException;
import com.twu.biblioteca.library.BookManager;
import org.junit.Test;
import java.util.Collection;
import static org.junit.Assert.*;

public class ReservationManagerTest {

    private Book getMockBook() {
        return new Book("9780140177398", "Of Mice and Men");
    }

    @Test
    public void testReservationManagerCreation() throws Exception {
        BookManager rm = new BookManager();
        assertNotNull(rm);
    }

    @Test
    public void testAddReservable() throws Exception {
        BookManager rm = new BookManager();
        Book book = getMockBook();
        rm.addBook(book);
        assertEquals(rm.getItemCount(), 1);
    }

    @Test
    public void testAddReservableDuplicate() throws Exception {
        BookManager rm = new BookManager();
        Book book1 = getMockBook();
        Book book2 = getMockBook();
        rm.addBook(book1);
        rm.addBook(book2);
        assertEquals(1, rm.getItemCount());
    }

    @Test
    public void testGetListOfBooks() throws Exception {
        BookManager rm = new BookManager();
        Book book = getMockBook();
        rm.addBook(book);
        assertEquals(rm.getItemCount(), 1);
        Collection<Book> bookCollection = rm.getAllItems();
        assertTrue(bookCollection.contains(book));
        assertEquals(1, bookCollection.size());
    }

    @Test
    public void testIsBookReserved() throws Exception {
        BookManager rm = new BookManager();
        Book book = getMockBook();
        rm.addBook(book);
        assertEquals(rm.isBookReserved(book.getISBN()), false);

    }

    @Test
    public void testReserveBook() throws Exception {
        BookManager rm = new BookManager();
        Book book = getMockBook();
        rm.addBook(book);
        assertEquals(false, rm.isBookReserved(book.getISBN()));
        boolean reserved = rm.reserveBook(book.getISBN());
        assertEquals(true, reserved);
    }

    @Test
    public void testReserveAlreadyReservedBook() throws Exception {
        BookManager rm = new BookManager();
        Book book = getMockBook();
        rm.addBook(book);
        rm.reserveBook(book.getISBN());
        boolean result = rm.reserveBook(book.getISBN());
        assertEquals(false, result);
    }

    @Test(expected=BookNotFoundException.class)
    public void testReserveUnknownBook() throws Exception {
        BookManager rm = new BookManager();
        boolean reserved = rm.reserveBook("randomISBN");
        assertFalse(reserved);
    }

    @Test(expected=BookNotFoundException.class)
    public void testCheckIsBookReserveOnUnknownBook() throws Exception {
        BookManager rm = new BookManager();
        boolean reserved = rm.isBookReserved("randomISBN");
        assertFalse(reserved);
    }
}
