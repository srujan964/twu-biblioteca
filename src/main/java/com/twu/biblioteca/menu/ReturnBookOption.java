package com.twu.biblioteca.menu;

import com.twu.biblioteca.ui.UserInterface;
import com.twu.biblioteca.exceptions.UnknownBookException;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Library;

// Job: Represent a menu option to return a book.
public class ReturnBookOption implements MenuOption {
    private final UserInterface userInterface;

    public ReturnBookOption(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        String bookTitle = userInterface.promptForBookName();
        Book book = null;
        try {
            book = library.findInCheckedOut(bookTitle);
        } catch (UnknownBookException e) {
            userInterface.handleUnsuccessfulReturn();
            return;
        }
        library.returnBook(book);
        userInterface.handleSuccessfulReturn();
    }

    @Override
    public String description() {
        return "Return a book";
    }
}
