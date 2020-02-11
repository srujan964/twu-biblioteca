package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Pet Sematary", "Stephen King", 1983);
    }

    @Test
    public void shouldReturnTitle() {
        String expectedTitle = "Pet Sematary";

        String actualTitle = book.getTitle();

        assertThat(actualTitle, is(equalTo(expectedTitle)));
    }

    @Test
    public void shouldReturnAuthorName() {
        String expectedAuthorName = "Stephen King";

        String actualAuthorName = book.getAuthor();

        assertThat(actualAuthorName, is(equalTo(expectedAuthorName)));
    }

    @Test
    public void shouldReturnYearOfPublication() {
        int expectedYearOfPublication = 1983;

        int actualYearOfPublication = book.getYearPublished();

        assertThat(actualYearOfPublication, is(equalTo(expectedYearOfPublication)));
    }
}