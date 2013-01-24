package com.twu.biblioteca.items;

public class Book {

    private final String ISBN;
    private final String title;

    public Book(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return ISBN + " - " + title;
    }

    /*
      Equals only tests on the ISBN since that is the unique ID, not the name etc
      Use in Maps and Sets.
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        if (ISBN != null ? !ISBN.equals(book.ISBN) : book.ISBN != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ISBN != null ? ISBN.hashCode() : 0;
    }
}
