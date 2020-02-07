package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BibliotecaAppTest {

    @Test
    public void shouldGreet() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedGreeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        String actualGreeting = bibliotecaApp.greet();

        assertThat(actualGreeting, is(equalTo(expectedGreeting)));
    }
}
