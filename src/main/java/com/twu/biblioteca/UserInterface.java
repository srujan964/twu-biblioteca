package com.twu.biblioteca;

import java.util.ArrayList;

public interface UserInterface {
    void displayListOfBooks(ArrayList<Book> books);

    void handleInvalidOption();

    void handleSuccessfulCheckout();

    void handleUnsuccessfulCheckout();

    void handleSuccessfulReturn();

    void handleUnsuccessfulReturn();

    void quit();

    String promptForBookName();
}
