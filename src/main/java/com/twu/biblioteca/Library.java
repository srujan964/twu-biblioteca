package com.twu.biblioteca;

import java.util.ArrayList;

// Job: Represent a library.
public class Library {
    private static final String WELCOME_GREETING = "Welcome to Biblioteca. " +
            "Your one-stop-shop for great book titles in Bangalore!";
    private final ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>() {{
            add(new Book("Pet Sematary"));
        }};
    }

    public String greet() {
        return WELCOME_GREETING;
    }

    public ArrayList<Book> listBooks() {
        return books;
    }
}
