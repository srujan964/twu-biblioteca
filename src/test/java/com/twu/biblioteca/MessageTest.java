package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static com.twu.biblioteca.logic.Message.*;
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

    @Test
    public void shouldDisplaySuccessfulCheckoutMessage() {
        String expectedCheckoutMessage = "Thank you! Enjoy the book";

        assertThat(SUCCESSFUL_CHECKOUT.getValue(), is(equalTo(expectedCheckoutMessage)));
    }

    @Test
    public void shouldDisplayUnsuccessfulCheckoutMessage() {
        String expectedCheckoutMessage = "Sorry, that book is not available";

        assertThat(UNSUCCESSFUL_CHECKOUT.getValue(), is(equalTo(expectedCheckoutMessage)));
    }

    @Test
    public void shouldDisplaySuccessfulReturnMessage() {
        String expectedReturnMessage = "Thank you for returning the book";

        assertThat(SUCCESSFUL_RETURN.getValue(), is(equalTo(expectedReturnMessage)));
    }

    @Test
    public void shouldDisplayUnsuccessfulReturnMessage() {
        String expectedReturnMessage = "That is not a valid book to return";

        assertThat(UNSUCCESSFUL_RETURN.getValue(), is(equalTo(expectedReturnMessage)));
    }
}