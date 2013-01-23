package com.twu.biblioteca;

public class  BibliotecaApp {
      public static void main(String[] args) {
        Library library = Library.getInstance();
        library.run();
    }
}
