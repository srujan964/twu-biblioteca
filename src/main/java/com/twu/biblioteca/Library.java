package com.twu.biblioteca;

import java.util.ArrayList;

// Job: Represent a library.
public class Library {
    private final ArrayList<Book> availableBooks;
    private final ArrayList<Book> checkedOutBooks;

    public Library() {
        availableBooks = new ArrayList<>() {{
            add(new Book("Pet Sematary", "Stephen King", 1983));
            add(new Book("Sharp Objects", "Gillian Flynn", 2006));
            add(new Book("The Handmaid's Tale", "Margaret Atwood", 1985));
        }};

        checkedOutBooks = new ArrayList<>();
    }

    public ArrayList<Book> listBooks() {
        return availableBooks;
    }

    public void checkout(Book book) {
        checkedOutBooks.add(book);
        availableBooks.remove(book);
    }

    public Book findInAvailable(String title) throws UnknownBookException {
        for (Book book : availableBooks) {
            if (book.getTitle().equals(title))
                return book;
        }
        throw new UnknownBookException();
    }

    public void returnBook(Book book) {
        checkedOutBooks.remove(book);
        availableBooks.add(book);
    }

    public Book findInCheckedOut(String title) {
        for (Book book : checkedOutBooks) {
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }
}
