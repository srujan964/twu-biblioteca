package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    @Test
    public void shouldReturnBookList() {
        Library library = new Library();
        ArrayList<Book> expectedBooks = new ArrayList<>() {{
            add(new Book("Pet Sematary", "Stephen King", 1983));
            add(new Book("Sharp Objects", "Gillian Flynn", 2006));
            add(new Book("The Handmaid's Tale", "Margaret Atwood", 1985));
        }};

        ArrayList<Book> actualBooks = library.listBooks();

        assertThat(actualBooks, is(equalTo(expectedBooks)));
    }

    @Test
    public void shouldCheckoutBook() {
        Library library = new Library();
        Book petSematary = new Book("Pet Sematary", "Stephen King", 1983);
        library.checkout(petSematary);
        ArrayList<Book> books = library.listBooks();

        assertFalse(books.contains(petSematary));
    }

    @Test
    public void shouldReturnBook() {
        Library library = new Library();
        Book petSematary = new Book("Pet Sematary", "Stephen King", 1983);
        library.checkout(petSematary);
        library.returnBook(petSematary);
        ArrayList<Book> books = library.listBooks();

        assertTrue(books.contains(petSematary));
    }
}
