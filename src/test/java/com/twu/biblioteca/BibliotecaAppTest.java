package com.twu.biblioteca;

import com.twu.biblioteca.logic.Message;
import com.twu.biblioteca.consoleui.BibliotecaApp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BibliotecaAppTest {
    PrintStream printStream;
    ByteArrayOutputStream byteArrayOutputStream;
    BibliotecaApp bibliotecaApp;

    @BeforeEach
    void setUp() {
        bibliotecaApp = new BibliotecaApp();
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void shouldHandleInvalidOption() {
        bibliotecaApp.handleInvalidOption();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(Message.INVALID_OPTION.getValue()));
    }

    @Test
    public void shouldHandleSuccessfulCheckout() {
        bibliotecaApp.handleSuccessfulCheckout();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(Message.SUCCESSFUL_CHECKOUT.getValue()));
    }

    @Test
    public void shouldHandleUnsuccessfulCheckout() {
        bibliotecaApp.handleUnsuccessfulCheckout();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(Message.UNSUCCESSFUL_CHECKOUT.getValue()));
    }

    @Test
    public void shouldHandleSuccessfulReturn() {
        bibliotecaApp.handleSuccessfulReturn();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(Message.SUCCESSFUL_RETURN.getValue()));
    }

    @Test
    public void shouldHandleUnsuccessfulReturn() {
        bibliotecaApp.handleUnsuccessfulReturn();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(Message.UNSUCCESSFUL_RETURN.getValue()));
    }
}