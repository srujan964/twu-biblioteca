package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static com.twu.biblioteca.Message.INVALID_OPTION;
import static com.twu.biblioteca.Message.WELCOME_GREETING;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MessageTest {

    @Test
    public void shouldGreet() {
        String expectedGreeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertThat(WELCOME_GREETING.getValue(), is(equalTo(expectedGreeting)));
    }

    @Test
    public void shouldDisplayInvalidOptionMessage() {
        String expectedInvalidOptionMessage = "Please select a valid option!";

        assertThat(INVALID_OPTION.getValue(), is(equalTo(expectedInvalidOptionMessage)));
    }
}