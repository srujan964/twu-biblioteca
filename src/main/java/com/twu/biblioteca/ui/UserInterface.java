package com.twu.biblioteca.ui;

import com.twu.biblioteca.logic.Book;

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
