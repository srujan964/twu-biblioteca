package com.twu.biblioteca.logic;

import com.twu.biblioteca.logic.menu.Menu;

import java.util.ArrayList;

// Represent a general user interface.
public interface UserInterface {
    void displayWelcomeGreeting();

    void displayListOfBooks(ArrayList<Book> books);

    void displayMenu(Menu menu);

    void handleInvalidOption();

    void handleSuccessfulCheckout();

    void handleUnsuccessfulCheckout();

    void handleSuccessfulReturn();

    void handleUnsuccessfulReturn();

    void quit();

    String promptForBookName();

    int getOption(Menu menu);
}
