package com.twu.biblioteca;

import org.junit.Test;
import java.util.Set;
import static org.junit.Assert.*;

public class ReservationManagerTest {

    @Test
    public void testReservationManagerCreation() throws Exception {
        ReservationManager rm = new ReservationManager();
        assertNotNull(rm);
    }

    @Test
    public void testAddReservable() throws Exception {
        ReservationManager rm = new ReservationManager();
        Book book = new Book("9780140177398", "Of Mice and Men");
        rm.addReservable(book);
        assertEquals(rm.getBookCount(), 1);
    }

    @Test
    public void testAddReservableDuplicate() throws Exception {
        ReservationManager rm = new ReservationManager();
        Book book1 = new Book("9780140177398", "Of Mice and Men");
        Book book2 = new Book("9780140177398", "Of Mice and Men");
        rm.addReservable(book1);
        rm.addReservable(book2);
        assertEquals(1, rm.getBookCount());
    }

    @Test
    public void testGetListOfBooks() throws Exception {
        ReservationManager rm = new ReservationManager();
        rm.addReservable(new Book("9780140177398", "Of Mice and Men"));
        assertEquals(rm.getBookCount(), 1);
        Set<Book> bookCollection = rm.getAllBooks();
        assertTrue(bookCollection.contains(new Book("9780140177398", "Of Mice and Men")));
        assertEquals(1, bookCollection.size());
    }

    @Test
    public void testIsBookReserved() throws Exception {
        ReservationManager rm = new ReservationManager();
        rm.addReservable(new Book("9780140177398", "Of Mice and Men"));
        assertEquals(rm.isBookReserved(new Book("9780140177398", "Of Mice and Men")), false);

    }

    @Test
    public void testReserveBook() throws Exception {
        ReservationManager rm = new ReservationManager();
        rm.addReservable(new Book("9780140177398", "Of Mice and Men"));
        assertEquals(false, rm.isBookReserved(new Book("9780140177398", "Of Mice and Men")));
        boolean reserved = rm.reserveBook(new Book("9780140177398", "Of Mice and Men"));
        assertEquals(true, reserved);
    }

    @Test
    public void testReserveAlreadyReservedBook() throws Exception {
        ReservationManager rm = new ReservationManager();
        rm.addReservable(new Book("9780140177398", "Of Mice and Men"));
        rm.reserveBook(new Book("9780140177398", "Of Mice and Men"));
        boolean result = rm.reserveBook(new Book("9780140177398", "Of Mice and Men"));
        assertEquals(false, result);
    }
}
