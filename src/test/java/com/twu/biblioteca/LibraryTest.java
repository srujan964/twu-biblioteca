package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class LibraryTest {

    @Test
    public void shouldGreet() {
        Library library = new Library();
        String expectedGreeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        String actualGreeting = library.greet();

        assertThat(actualGreeting, is(equalTo(expectedGreeting)));
    }
}