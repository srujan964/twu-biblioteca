package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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
}
