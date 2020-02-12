package com.twu.biblioteca;

import com.twu.biblioteca.consoleui.Console;
import com.twu.biblioteca.logic.menu.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.twu.biblioteca.logic.Message.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class ConsoleTest {

    PrintStream printStream;
    ByteArrayOutputStream byteArrayOutputStream;
    ByteArrayInputStream byteArrayInputStream;
    Console console;
    String optionData;

    @BeforeEach
    void setUp() {
        Scanner scanner = new Scanner(System.in);
        console = new Console(scanner);
        optionData = "1\nYababada\n";
        byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayInputStream = new ByteArrayInputStream(optionData.getBytes());
        printStream = new PrintStream(byteArrayOutputStream);
        System.setIn(byteArrayInputStream);
        System.setOut(printStream);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void shouldHandleInvalidOption() {
        console.handleInvalidOption();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(INVALID_OPTION));
    }

    @Test
    public void shouldHandleSuccessfulCheckout() {
        console.handleSuccessfulCheckout();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(SUCCESSFUL_CHECKOUT));
    }

    @Test
    public void shouldHandleUnsuccessfulCheckout() {
        console.handleUnsuccessfulCheckout();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(UNSUCCESSFUL_CHECKOUT));
    }

    @Test
    public void shouldHandleSuccessfulReturn() {
        console.handleSuccessfulReturn();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(SUCCESSFUL_RETURN));
    }

    @Test
    public void shouldHandleUnsuccessfulReturn() {
        console.handleUnsuccessfulReturn();

        assertTrue(new String(byteArrayOutputStream.toByteArray()).contains(UNSUCCESSFUL_RETURN));
    }

    @Test
    public void shouldGetOption() {
        Menu menu = mock(Menu.class);
        int expectedOptionInput = 1;
        int actualOptionInput = console.getOption(menu);

        assertThat(actualOptionInput, is(equalTo(expectedOptionInput)));
    }

    @Test
    public void shouldGetBookTitle() {
        String expectedTitle = "Yababada";

        String actualTitle = console.promptForBookName();

        assertThat(actualTitle, is(equalTo(expectedTitle)));
    }
}