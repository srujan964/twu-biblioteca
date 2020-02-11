package com.twu.biblioteca.logic.menu;

import com.twu.biblioteca.logic.UserInterface;
import com.twu.biblioteca.logic.exceptions.UnknownBookException;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Library;

// Job: Represent a menu option to checkout a book.
public class CheckOutBookOption implements MenuOption {
    private final UserInterface userInterface;

    public CheckOutBookOption(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        String bookTitle = userInterface.promptForBookName();
        Book book = null;
        try {
            book = library.findInAvailable(bookTitle);
        } catch (UnknownBookException e) {
            userInterface.handleUnsuccessfulCheckout();
            return;
        }
        library.checkout(book);
        userInterface.handleSuccessfulCheckout();
    }

    @Override
    public String description() {
        return "Checkout a book";
    }
}
