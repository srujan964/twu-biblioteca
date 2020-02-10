package com.twu.biblioteca;

import java.util.ArrayList;

// Job: Represent a library.
public class Library {
    private final ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>() {{
            add(new Book("Pet Sematary", "Stephen King", 1983));
            add(new Book("Sharp Objects", "Gillian Flynn", 2006));
            add(new Book("The Handmaid's Tale", "Margaret Atwood", 1985));
        }};
    }

    public ArrayList<Book> listBooks() {
        return books;
    }

    public void checkout(Book book) {
        books.remove(book);
    }

    public Book find(String title) throws UnknownBookException {
        for (Book book : books) {
            if (book.getTitle().equals(title))
                return book;
        }
        throw new UnknownBookException();
    }
}
